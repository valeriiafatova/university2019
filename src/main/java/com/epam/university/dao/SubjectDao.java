package com.epam.university.dao;

import com.epam.university.entity.Subject;

import java.util.List;

public class SubjectDao extends AbstractDao<Subject> {
    private static final String SELECT_ALL = "SELECT * FROM subject";
    private static final String COLUMN_TITLE = "title";

    @Override
    public List<Subject> getAll() {
        return getAll(SELECT_ALL, resultSet -> new Subject(resultSet.getInt(COLUMN_ID),resultSet.getString(COLUMN_TITLE)));
    }
}
