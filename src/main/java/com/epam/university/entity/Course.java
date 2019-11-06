package com.epam.university.entity;

public class Course {
    private int id;
    private String title;
    private String description;
    private int lecturerId;

    public Course() {
    }

    public Course(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Course(int id, String title, String description, int lecturerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lecturerId = lecturerId;
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

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", title='" + title + '\'' + '}' + "\n";
    }
}
