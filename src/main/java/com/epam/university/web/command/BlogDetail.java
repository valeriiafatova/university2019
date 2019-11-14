package com.epam.university.web.command;

import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.BLOG_DETAIL_PAGE;

public class BlogDetail implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(BLOG_DETAIL_PAGE);
    }
}
