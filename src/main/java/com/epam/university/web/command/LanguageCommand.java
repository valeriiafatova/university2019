package com.epam.university.web.command;

import com.epam.university.web.data.Page;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


public class LanguageCommand implements Command {
    
    public static final String LOCALE = "locale";

    @Override
    public Page perform(HttpServletRequest request) {
        String locale = request.getParameter(LOCALE);
        
        request.getSession().setAttribute(LOCALE, locale);
        
        return new Page("/", true);
    }
}
