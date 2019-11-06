package com.epam.university.entity;

import java.util.List;

public class Outline {

    private int id;
    private String title;
    private int courseId;

    public Outline() {
    }
    
    public Outline(int id, String title, int courseId) {
        this.id = id;
        this.title = title;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
