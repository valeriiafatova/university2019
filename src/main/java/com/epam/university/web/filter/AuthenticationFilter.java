package com.epam.university.web.filter;

import com.epam.university.entity.User;
import com.epam.university.enums.Role;
import com.epam.university.security.SecurityConfig;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private static final Logger LOG = Logger.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String path = getPath(httpServletRequest);

        if (isNotSecuredPage(path)) {
            LOG.debug("Page is not secured: " + path);
            chain.doFilter(request, response);
            return;
        }
        String contextPath = httpServletRequest.getContextPath();

        HttpSession session = httpServletRequest.getSession();
        
        User user = (User) session.getAttribute("user");
        if (user == null) {
            LOG.info("User not logged");
            httpServletResponse.sendRedirect(contextPath + "/registration");
            return;
        }

        if (hasNotPermission(path, user.getRole())) {
            LOG.debug("User has not permission : " + user + " , " + path);
            httpServletResponse.sendRedirect(contextPath + "/403-error");
            return;
        }

        LOG.debug("User has permission. Continue");
        chain.doFilter(request, response);
    }

    private boolean hasNotPermission(String path, Role role) {
        return !SecurityConfig.hasPermission(path, role);
    }

    private boolean isNotSecuredPage(String path) {
        return !SecurityConfig.isSecurePage(path);
    }

    @Override
    public void destroy() {

    }

    private String getPath(HttpServletRequest req) {
        String requestUri = req.getRequestURI();
        int lastPath = requestUri.lastIndexOf('/');
        String path = requestUri.substring(lastPath);
        LOG.info("Path: " + path);
        return path;
    }
}
