package com.epam.university.web.tags;

import com.epam.university.entity.User;
import com.epam.university.enums.Role;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Objects;

public class AuthenticationTag extends TagSupport {
    private String role;

    @Override
    public int doStartTag() throws JspException {
        User user = getUser();

        if (role == null || user == null) {
            return SKIP_BODY;
        }
        Role userRole = user.getRole();
        if (role.contains(userRole.toString())) {
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return (User) getSession().getAttribute("user");
    }

    public HttpSession getSession() {
        return pageContext.getSession();
    }


}
