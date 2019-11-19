package com.epam.university.web.command;

import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.CourseService;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.COURSE_DETAILS_PAGE;
import static com.epam.university.constant.PageUrlConstants.COURSE_PAGE;

public class CourseCommand extends MultipleMethodCommand {
    private CourseService courseService;

    public CourseCommand() {
        this.courseService = ServiceFactory.getCourseService();
    }
    
    @Override
    protected Page performGet(HttpServletRequest request) {
        String course_id = request.getParameter("course_id");

        if (course_id != null) {
            return new Page(COURSE_DETAILS_PAGE);
        }

        request.setAttribute("courses", courseService.getAll());
        return new Page(COURSE_PAGE);    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        return null;
    }
}
