package com.epam.university.dao;

import com.epam.university.entity.Rating;
import com.epam.university.enums.Ratings;

import java.util.List;

public class RatingDao extends AbstractDao<Rating> {

    private static final String SELECT_FROM_RATING = "SELECT * FROM `rating`";
    private static final String COLUMN_STUDENT_ID = "studentId";
    private static final String COLUMN_SUBJECT_ID = "subjectId";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_RATING = "rating";

    @Override
    public List<Rating> getAll() {
        return getAll(SELECT_FROM_RATING,
                resultSet -> new Rating(resultSet.getInt(COLUMN_ID), resultSet.getInt(COLUMN_STUDENT_ID),
                        resultSet.getInt(COLUMN_SUBJECT_ID), resultSet.getDate(COLUMN_DATE),
                        Ratings.valueOf(resultSet.getString(COLUMN_RATING))));
    }
}
