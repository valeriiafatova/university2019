package com.epam.university.dao;

import com.epam.university.entity.Major;
import org.apache.log4j.Logger;

import java.util.List;

public class MajorDao extends AbstractDao<Major> {
    private static final Logger LOG = Logger.getLogger(MajorDao.class);
    
    private static final String COLUMN_TITLE = "title";
    private static final String SELECT_FROM_MAJOR = "SELECT * FROM major";

    private static final String INSERT_INTO_MAJOR = "INSERT INTO major ("
            + COLUMN_TITLE + ") VALUE (?)";

    private static final String UPDATE_MAJOR = "UPDATE major "
            + COLUMN_TITLE + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_MAJOR = "DELETE FROM major "
            + "WHERE " + COLUMN_ID + " = ?";


    @Override
    public List<Major> getAll() {
        return getAll(SELECT_FROM_MAJOR, resultSet -> new Major(resultSet.getInt(COLUMN_ID), 
                resultSet.getString(COLUMN_TITLE)));
    }

    @Override
    public boolean create(Major entity) {
        return createUpdate(INSERT_INTO_MAJOR, ps -> ps.setString(1, entity.getTitle()));
    }

    @Override
    public boolean update(Major entity) {
        return createUpdate(UPDATE_MAJOR, ps -> {
            ps.setString(1, entity.getTitle());
            ps.setInt(2, entity.getId());
        });
    }

    @Override
    public boolean remove(Major entity){
        LOG.debug("Delete major: " + entity);
        return createUpdate(DELETE_MAJOR, ps -> ps.setInt(1, entity.getId()));
    }

}
