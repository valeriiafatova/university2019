package com.epam.university.factory;

import com.epam.university.service.CourseService;
import com.epam.university.service.UserService;

public class ServiceFactory {
    private ServiceFactory() {
    }
    
    private static CourseService courseService = new CourseService();
    private static UserService userService = new UserService();
    
    public static CourseService getCourseService(){
        return courseService;
    }

    public static UserService getUserService() {
        return userService;
    }
}
