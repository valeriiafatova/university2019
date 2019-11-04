package com.epam.university.web;

import com.epam.university.web.command.Command;
import com.epam.university.web.command.CommandFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/app/*")
public class UserServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(UserServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPerform(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPerform(req, resp);
    }

    private void doPerform(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Context Path : " + req.getContextPath());
        LOG.info("Servlet Path : " + req.getServletPath());
        LOG.info("Request URI : " + req.getRequestURI());
        LOG.info("Request URL : " + req.getRequestURL());

        String requestUri = req.getRequestURI();
        int i = requestUri.lastIndexOf("/");
        String substring = requestUri.substring(i + 1);
        LOG.info("Substring: " + substring );

        Command userCommand = CommandFactory.getCommand(substring);
        String url = userCommand.perform(req);

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
