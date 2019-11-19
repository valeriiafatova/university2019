package com.epam.university.web.command.pages;

import com.epam.university.web.command.Command;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.HOME_PAGE;

public class SearchCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(HOME_PAGE);
    }
}
