package com.epam.university.web.command;

import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public class NotFoundCommand implements Command {
    
    @Override
    public Page perform(HttpServletRequest request){
        return new Page("/404.html");
    }
}
