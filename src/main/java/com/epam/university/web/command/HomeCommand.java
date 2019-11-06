package com.epam.university.web.command;

import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.CourseService;
import com.epam.university.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements Command{
    private static final Logger LOG = Logger.getLogger(HomeCommand.class);
    private CourseService courseService;

    public HomeCommand() {
        this.courseService = ServiceFactory.getCourseService();
    }

    @Override
    public Page perform(HttpServletRequest request) {
        request.setAttribute("courses", courseService.getAll());
//        String redirectUrl = request.getContextPath() + "/app/404";
//        LOG.info("Redirect Url: " + redirectUrl);
        //return new Page(redirectUrl, true);
        return new Page("/ui/index.jsp");
    }
}
