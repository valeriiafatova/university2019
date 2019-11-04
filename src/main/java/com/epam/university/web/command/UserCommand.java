package com.epam.university.web.command;

import com.epam.university.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

public class UserCommand implements Command{
    private static UserDao userDao = new UserDao();

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userCount = userDao.getAll().stream().count();
        request.setAttribute("count", userCount);
        request.getRequestDispatcher("/user.jsp").forward(request,response);
    }

    @Override
    public String perform(HttpServletRequest request) throws ServletException, IOException {
        request.getMethod();
        return request.getMethod() == "GET" ?  performGet(request) : performPost(request);
    }

    private String performGet(HttpServletRequest request) {
        long userCount = userDao.getAll().stream().count();
        request.setAttribute("count", userCount);
        return "/user.jsp";
    }
    
    private String performPost(HttpServletRequest request){
        return "";
    }
}
