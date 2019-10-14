package com.epam.university.dao;

import com.epam.university.entity.Major;

import java.util.List;

public class MajorDao extends AbstractDao<Major> {

    private static final String SELECT_FROM_MAJOR = "SELECT * FROM major";
    private static final String COLUMN_TITLE = "title";

    @Override
    public List<Major> getAll() {
        return getAll(SELECT_FROM_MAJOR, resultSet -> new Major(resultSet.getInt(COLUMN_ID), 
                resultSet.getString(COLUMN_TITLE)));
    }
}
