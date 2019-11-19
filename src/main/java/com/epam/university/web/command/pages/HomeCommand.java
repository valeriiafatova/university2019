package com.epam.university.web.command.pages;

import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.CourseService;
import com.epam.university.web.command.Command;
import com.epam.university.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.HOME_PAGE;

public class HomeCommand implements Command {
    private static final Logger LOG = Logger.getLogger(HomeCommand.class);
    private CourseService courseService;

    public HomeCommand() {
        this.courseService = ServiceFactory.getCourseService();
    }

    @Override
    public Page perform(HttpServletRequest request) {
        request.setAttribute("courses", courseService.getAll());
        return new Page(HOME_PAGE);
    }
}
