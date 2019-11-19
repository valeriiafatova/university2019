package com.epam.university.web.command;

import com.epam.university.entity.User;
import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.UserService;
import com.epam.university.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand extends MultipleMethodCommand {
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);
    
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

        Optional<User> optionalUser = userService.validateUser(login, password);
        if (optionalUser.isPresent()) {
            LOG.info("Login success");
            
            User user = optionalUser.get();
            session.setAttribute("user", user);
            return new Page("/", true);
        }

        session.setAttribute("error", "Error");
        return new Page("/", true);
        
    }
}
