package com.epam.university.entity;

import com.epam.university.enums.Ratings;

import java.time.LocalDate;

public class Rating {
    private int id;
    private int studentId;
    private int subjectId;
    private LocalDate date;
    private Ratings rating;

    public Rating(int id, int studentId, int subjectId, LocalDate date, Ratings rating) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.date = date;
        this.rating = rating;
    }

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Ratings getRating() {
        return rating;
    }

    public void setRating(Ratings rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" + "id=" + id + ", studentId=" + studentId + ", subjectId=" + subjectId + ", date=" + date +
                ", rating=" + rating + '}' + "\n";
    }
}
