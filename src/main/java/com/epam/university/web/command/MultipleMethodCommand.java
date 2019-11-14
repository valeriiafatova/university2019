package com.epam.university.web.command;

import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public abstract class MultipleMethodCommand implements Command {

    @Override
    public Page perform(HttpServletRequest request) {
        String type = request.getMethod();

        return "GET".equals(type)
                ? performGet(request)
                : performPost(request);
    }

    protected abstract Page performGet(HttpServletRequest request);

    protected abstract Page performPost(HttpServletRequest request);
}