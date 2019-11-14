package com.epam.university.web.command;

import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.CourseService;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.COURSE_PAGE;

public class CourseCommand implements Command {
    private CourseService courseService;
    
    public CourseCommand() {
        this.courseService = ServiceFactory.getCourseService();
    }

    @Override
    public Page perform(HttpServletRequest request) {
        request.setAttribute("courses", courseService.getAll());
        return new Page(COURSE_PAGE);
    }
}
