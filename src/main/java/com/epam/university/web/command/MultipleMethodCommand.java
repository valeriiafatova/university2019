package com.epam.university.web.command;

import com.epam.university.web.data.Page;
import com.epam.university.web.form.mapper.RequestFormMapper;
import com.epam.university.web.form.validator.FormValidator;

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
    
    protected <T> T mapForm(HttpServletRequest request, RequestFormMapper<T> mapper){
        return mapper.map(request);
    }

    protected <T> boolean validateForm(T form, FormValidator<T> formValidator){
        return formValidator.validate(form);
    }
}
