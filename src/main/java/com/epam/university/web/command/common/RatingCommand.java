package com.epam.university.web.command.common;

import com.epam.university.web.command.MultipleMethodCommand;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public class RatingCommand extends MultipleMethodCommand {
    @Override
    protected Page performGet(HttpServletRequest request) {
        return null;
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        return null;
    }
}
