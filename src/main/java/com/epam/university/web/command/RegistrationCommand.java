package com.epam.university.web.command;

import com.epam.university.entity.User;
import com.epam.university.enums.Role;
import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.UserService;
import com.epam.university.web.data.Page;
import com.epam.university.web.form.RegistrationForm;
import com.epam.university.web.form.validator.RegistrationFormValidator;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static com.epam.university.constant.PageUrlConstants.REGISTER_PAGE;

public class RegistrationCommand extends MultipleMethodCommand {
    private static final Logger LOG = Logger.getLogger(RegistrationCommand.class);

    private UserService userService;

    public RegistrationCommand() {
        this.userService = ServiceFactory.getUserService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(REGISTER_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String login = request.getParameter("login");

        boolean exist = userService.isExist(login);
        
        LOG.info(String.format("User with login % already exist %b", login, exist));
        
        if (exist) {
            return processError(request, "User already exist");
        }

        RegistrationForm registrationForm = getRegistrationForm(request);

        if (isFormNotValid(registrationForm)) {
            LOG.info("Registration form is invalid");
            return processError(request, "Invalid form");
        }

        Optional<User> user = userService.createUser(registrationForm);

        if (user.isPresent()) {
            LOG.info("Redirect to home user.");
            request.getSession().setAttribute("user", user.get());
            return new Page("/", true);
        }

        return processError(request, "Could not create user");
    }

    private Page processError(HttpServletRequest request, String s) {
        request.setAttribute("error", s);
        return new Page(REGISTER_PAGE);
    }

    private boolean isFormNotValid(RegistrationForm registrationForm) {
        return !RegistrationFormValidator.validate(registrationForm);
    }

    private RegistrationForm getRegistrationForm(HttpServletRequest request) {
        return mapForm(request,
                req -> new RegistrationForm(request.getParameter("first_name"), request.getParameter("last_name"),
                        request.getParameter("login"), request.getParameter("password"),
                        request.getParameter("password_confirm"), Role.STUDENT));
    }

}
