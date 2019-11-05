package com.epam.university.web.command;

import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements Command{
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page("index.jsp");
    }
}
