package com.epam.university.entity;

import java.util.List;

public class Major {

    private int id;
    private String title;
    private List<Subject> subjects;

    public Major() {
    }

    public Major(int id, String title) {
        this.id = id;
        this.title = title;
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
