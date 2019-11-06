package com.epam.university.web.command;

import com.epam.university.dao.EntityDao;
import com.epam.university.dto.CourseDTO;
import com.epam.university.dto.UserDTO;
import com.epam.university.entity.Course;
import com.epam.university.entity.User;
import com.epam.university.enums.DaoType;
import com.epam.university.factory.DaoFactory;
import com.epam.university.factory.ServiceFactory;
import com.epam.university.service.CourseService;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public class CourseCommand implements Command {
    private CourseService courseService;
    
    public CourseCommand() {
        this.courseService = ServiceFactory.getCourseService();
    }

    @Override
    public Page perform(HttpServletRequest request) {
        request.setAttribute("courses", courseService.getAll());
        return new Page("/ui/courses.jsp");
    }
}
