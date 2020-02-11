package com.epam.university.web.command.pages;

import com.epam.university.web.command.Command;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.FORBIDDEN_PAGE;

public class ForbiddenCommand implements Command {
    
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(FORBIDDEN_PAGE);
    }
}
