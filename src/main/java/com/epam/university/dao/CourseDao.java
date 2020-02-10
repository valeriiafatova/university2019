package com.epam.university.dao;

import com.epam.university.entity.Course;
import org.apache.log4j.Logger;

import java.util.List;

public class CourseDao extends AbstractDao<Course> {
    private static final Logger LOG = Logger.getLogger(CourseDao.class);

    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_LECTURER_ID = "lecturer_id";
    private static final String SELECT_ALL = "SELECT * FROM course";

    private static final String INSERT_INTO_COURSE =
            "INSERT INTO course (" + COLUMN_TITLE + ", " + COLUMN_DESCRIPTION + ") VALUE (?, ?)";

    private static final String UPDATE_COURSE =
            "UPDATE course " + COLUMN_TITLE + "=?, " + COLUMN_DESCRIPTION + "= ? WHERE " + COLUMN_ID + " = ?";

    private static final String DELETE_COURSE = "DELETE FROM course " + "WHERE " + COLUMN_ID + " = ?";

    public static final String SELECT_ALL_FULL =
            "SELECT * FROM `course` join `course_lecturer` on course_lecturer.course_id = course.id ";
    public static final String GET_BY_ID_FULL = SELECT_ALL_FULL + "WHERE course.id = ?";

    public static final String GET_BY_ID = "SELECT * FROM `course` WHERE id = ?";

    @Override
    public Course getById(int id, boolean full) {
        return full ? getById(GET_BY_ID_FULL, ps -> ps.setInt(1, id), getFullMapper()) :
                getById(GET_BY_ID, ps -> ps.setInt(1, id), getMapper());
    }
    
    @Override
    public List<Course> getAll(boolean full) {
        return full ? getAll(SELECT_ALL_FULL, getFullMapper()) : getAll(SELECT_ALL, getMapper());
    }

    @Override
    public List<Course> getAll() {
        return getAll(SELECT_ALL, getMapper());
    }
    
    @Override
    public boolean create(Course entity) {
        return createUpdate(INSERT_INTO_COURSE, ps -> {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getDescription());
        });
    }

    @Override
    public boolean update(Course entity) {
        return createUpdate(UPDATE_COURSE, ps -> {
            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getDescription());
            ps.setInt(3, entity.getId());
        });
    }

    @Override
    public boolean remove(Course entity) {
        LOG.debug("Delete rating: " + entity);
        return createUpdate(DELETE_COURSE, ps -> ps.setInt(1, entity.getId()));
    }

    private EntityMapper<Course> getFullMapper() {
        return resultSet -> new Course(resultSet.getInt(COLUMN_ID), resultSet.getString(COLUMN_TITLE),
                resultSet.getString(COLUMN_DESCRIPTION), resultSet.getInt(COLUMN_LECTURER_ID));
    }

    private EntityMapper<Course> getMapper() {
        return resultSet -> new Course(resultSet.getInt(COLUMN_ID), resultSet.getString(COLUMN_TITLE),
                resultSet.getString(COLUMN_DESCRIPTION));
    }
}
