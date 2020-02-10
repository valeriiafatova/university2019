package com.epam.university.dao;

import com.epam.university.entity.Rating;
import com.epam.university.enums.Ratings;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class RatingDao extends AbstractDao<Rating> {
    private static final Logger LOG = Logger.getLogger(RatingDao.class);
    private static final String COLUMN_STUDENT_ID = "student_id";
    private static final String COLUMN_COURSE_ID = "course_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_RATING = "rating";

    private static final String SELECT_FROM_RATING = "SELECT * FROM `rating`";
    private static final String INSERT_INTO_RATING_FULL =
            "INSERT INTO rating (" + COLUMN_STUDENT_ID + ", " + COLUMN_COURSE_ID + ", " + COLUMN_DATE + ", " +
                    COLUMN_RATING + ") VALUE (?, ?, ?, ?)";

    private static final String INSERT_INTO_RATING =
            "INSERT INTO rating (" + COLUMN_STUDENT_ID + ", " + COLUMN_COURSE_ID + ") VALUE (?, ?)";

    private static final String UPDATE_RATING =
            "UPDATE rating " + COLUMN_STUDENT_ID + "= ?, " + COLUMN_COURSE_ID + "= ?, " + COLUMN_DATE + "= ?, " +
                    COLUMN_RATING + "= ? WHERE " + COLUMN_ID + " = ?";

    private static final String DELETE_RATING = "DELETE FROM rating " + "WHERE " + COLUMN_ID + " = ?";

    @Override
    public List<Rating> getAll() {
        return getAll(SELECT_FROM_RATING, resultSet -> {
            LocalDate ratingDate = resultSet.getDate(COLUMN_DATE) != null 
                            ? resultSet.getDate(COLUMN_DATE).toLocalDate() 
                            : null;
            Ratings rating = resultSet.getString(COLUMN_RATING) != null 
                            ? Ratings.valueOf(resultSet.getString(COLUMN_RATING)) 
                            : null;
            return new Rating(resultSet.getInt(COLUMN_ID), resultSet.getInt(COLUMN_STUDENT_ID),
                    resultSet.getInt(COLUMN_COURSE_ID), ratingDate, rating);
        });
    }

    @Override
    public boolean create(Rating rating) {
        return create(rating, false);
    }

    @Override
    public boolean create(Rating rating, boolean full) {
        return full ? createUpdate(INSERT_INTO_RATING_FULL, getFullRatingStatementMapper(rating)) :
                createUpdate(INSERT_INTO_RATING, getRatingStatementMapper(rating));
    }


    @Override
    public boolean update(Rating rating) {
        return createUpdate(UPDATE_RATING, ps -> {
            ps.setInt(1, rating.getStudentId());
            ps.setInt(2, rating.getCourseId());
            ps.setDate(3, Date.valueOf(rating.getDate()));
            ps.setString(4, rating.getRating().toString());
            ps.setInt(5, rating.getId());
        });
    }

    @Override
    public boolean remove(Rating entity) {
        LOG.debug("Delete rating: " + entity);
        return createUpdate(DELETE_RATING, ps -> ps.setInt(1, entity.getId()));
    }

    private StatementMapper<Rating> getFullRatingStatementMapper(Rating rating) {
        return ps -> {
            ps.setInt(1, rating.getStudentId());
            ps.setInt(2, rating.getCourseId());
            ps.setDate(3, Date.valueOf(rating.getDate()));
            ps.setString(4, rating.getRating().toString());
        };
    }

    private StatementMapper<Rating> getRatingStatementMapper(Rating rating) {
        return ps -> {
            ps.setInt(1, rating.getStudentId());
            ps.setInt(2, rating.getCourseId());
        };
    }
}
