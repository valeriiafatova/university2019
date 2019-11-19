package com.epam.university.web.command;

import com.epam.university.entity.User;
import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.UserService;
import com.epam.university.web.data.Page;
import com.epam.university.web.data.AjaxResponse;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand extends MultipleMethodCommand {
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);
    
    private UserService userService;
    private static Gson gson = new Gson();
    
    public LoginCommand() {
        this.userService = ServiceFactory.getUserService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return null;
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        LOG.debug(String.format("Login %s, password %s", login, password));
        
        Optional<User> optionalUser = userService.validateUser(login, password);
        
        AjaxResponse ajaxResponse = new AjaxResponse();
        if (optionalUser.isPresent()) {
            LOG.info("Login success");
            
            User user = optionalUser.get();
            session.setAttribute("user", user);
            ajaxResponse.setUrl("");
            ajaxResponse.setSuccess(true);
            return getPage(ajaxResponse);
        }

        ajaxResponse.setMessage("Invalid credential! Please, try again.");
        return getPage(ajaxResponse);
    }

    private Page getPage(AjaxResponse ajaxResponse) {
        return new Page(true, gson.toJson(ajaxResponse));
    }
}
