package com.epam.university.dto;

public class CourseDTO {
    private int id;
    private String title;
    private String description;
    private UserDTO lecturer;

    public CourseDTO() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getLecturer() {
        return lecturer;
    }

    public void setLecturer(UserDTO lecturer) {
        this.lecturer = lecturer;
    }
}
