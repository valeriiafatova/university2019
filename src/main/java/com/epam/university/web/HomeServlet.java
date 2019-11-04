package com.epam.university.web;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/home", "/hi"})
public class HomeServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(HomeServlet.class);

   
    @Override
    public void init() {
        LOG.info("Init");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        LOG.info("Destroy");
    }

}
