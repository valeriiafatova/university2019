package com.epam.university.dao;

import com.epam.university.entity.Subject;
import com.epam.university.entity.User;
import org.apache.log4j.Logger;

import java.util.List;

public class SubjectDao extends AbstractDao<Subject> {
    private static final Logger LOG = Logger.getLogger(SubjectDao.class);
    
    private static final String COLUMN_TITLE = "title";
    private static final String SELECT_ALL = "SELECT * FROM subject";
    
    private static final String INSERT_INTO_SUBJECT = "INSERT INTO subject ("
            + COLUMN_TITLE + ") VALUE (?)";

    private static final String UPDATE_SUBJECT = "UPDATE subject "
            + COLUMN_TITLE + "= ? WHERE "
            + COLUMN_ID + " = ?";
    
    private static final String DELETE_SUBJECT = "DELETE FROM subject "
            + "WHERE " + COLUMN_ID + " = ?";
    public static final String SELECT_FULL =
            "SELECT * FROM `subject` join `subject_lecturer` on subject_lecturer.subjectId = subject.id ";

    @Override
    public Subject getById(int id, boolean full) {
        return full ?
                getById(SELECT_FULL + "WHERE subject.id = ?",
                        ps -> ps.setInt(1, id), getFullMapper()) :
                getById("SELECT * FROM `subject` WHERE id = ?", ps -> ps.setInt(1, id), getSubjectEntityMapper());
    }

    private EntityMapper<Subject> getFullMapper() {
        return resultSet -> new Subject(resultSet.getInt(COLUMN_ID), resultSet.getString(COLUMN_TITLE),
                resultSet.getInt("lecturerId"));
    }

    @Override
    public List<Subject> getAll(boolean full) {
        return full 
                ? getAll(SELECT_FULL, getFullMapper()) 
                :  getAll(SELECT_ALL, getSubjectEntityMapper());
    }

    @Override
    public List<Subject> getAll() {
        return getAll(SELECT_ALL, getSubjectEntityMapper());
    }

    private EntityMapper<Subject> getSubjectEntityMapper() {
        return resultSet -> new Subject(resultSet.getInt(COLUMN_ID),resultSet.getString(COLUMN_TITLE));
    }

    @Override
    public boolean create(Subject entity) {
        return createUpdate(INSERT_INTO_SUBJECT, ps -> ps.setString(1, entity.getTitle()));
    }

    @Override
    public boolean update(Subject entity) {
        return createUpdate(UPDATE_SUBJECT, ps -> {
            ps.setString(1, entity.getTitle());
            ps.setInt(2, entity.getId());
        });
    }

    @Override
    public boolean remove(Subject entity){
        LOG.debug("Delete rating: " + entity);
        return createUpdate(DELETE_SUBJECT, ps -> ps.setInt(1, entity.getId()));
    }
    
}
