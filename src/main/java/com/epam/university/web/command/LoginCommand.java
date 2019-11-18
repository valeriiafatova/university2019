package com.epam.university.web.command;

import com.epam.university.entity.User;
import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.UserService;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand extends MultipleMethodCommand {
    private UserService userService;

    public LoginCommand() {
        this.userService = ServiceFactory.getUserService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return null;
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("login: " + login + ", password: " + password);

        HttpSession session = request.getSession();

        int userId = userService.validateUser(login, password);
        if (userId != 0) {
            User user = userService.getUser(userId);
            session.setAttribute("user", user);
            return new Page("/", true);
        }

        session.setAttribute("error", "Error");
        return new Page("/", true);
        
    }
}
