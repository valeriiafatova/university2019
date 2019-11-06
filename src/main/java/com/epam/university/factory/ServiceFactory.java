package com.epam.university.factory;

import com.epam.university.service.CourseService;

public class ServiceFactory {
    private ServiceFactory() {
    }
    
    private static CourseService courseService = new CourseService();
    
    public static CourseService getCourseService(){
        return courseService;
    }
}
