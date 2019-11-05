package com.epam.university.web.command;

import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    
    Page perform(HttpServletRequest request);
}
