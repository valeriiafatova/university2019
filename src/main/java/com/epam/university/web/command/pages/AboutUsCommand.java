package com.epam.university.web.command.pages;

import com.epam.university.web.command.Command;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.ABOUT_US_PAGE;

public class AboutUsCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(ABOUT_US_PAGE);
    }
}
