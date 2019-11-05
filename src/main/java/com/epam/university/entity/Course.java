package com.epam.university.entity;

public class Subject {
    private int id;
    private String title;
    private int lecturerId;

    public Subject() {
    }

    public Subject(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Subject(int id, String title, int lecturerId) {
        this.id = id;
        this.title = title;
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

    @Override
    public String toString() {
        return "Subject{" + "id=" + id + ", title='" + title + '\'' + '}' + "\n";
    }
}
