package com.epam.university.entity;

import java.util.List;

public class Lecturer extends User {
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
