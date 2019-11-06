package com.epam.university.dao;

import com.epam.university.entity.Outline;
import org.apache.log4j.Logger;

import java.util.List;

public class OutlineDao extends AbstractDao<Outline> {
    private static final Logger LOG = Logger.getLogger(OutlineDao.class);
    
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_COURSE_ID = "course_id";
    private static final String SELECT_FROM_OUTLINE = "SELECT * FROM outline";

    private static final String INSERT_INTO_OUTLINE = "INSERT INTO outline ("
            + COLUMN_TITLE +", " 
            + COLUMN_COURSE_ID + ") VALUE (?, ?)";

    private static final String UPDATE_OUTLINE = "UPDATE outline "
            + COLUMN_TITLE + " = ?, "
            + COLUMN_COURSE_ID + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_OUTLINE = "DELETE FROM outline "
            + "WHERE " + COLUMN_ID + " = ?";


    @Override
    public List<Outline> getAll() {
        return getAll(SELECT_FROM_OUTLINE, resultSet -> new Outline(resultSet.getInt(COLUMN_ID), 
                resultSet.getString(COLUMN_TITLE), 
                resultSet.getInt(COLUMN_COURSE_ID)));
    }

    @Override
    public boolean create(Outline entity) {
        return createUpdate(INSERT_INTO_OUTLINE, ps -> {
            ps.setString(1, entity.getTitle());
            ps.setInt(2, entity.getCourseId());
        });
    }

    @Override
    public boolean update(Outline entity) {
        return createUpdate(UPDATE_OUTLINE, ps -> {
            ps.setString(1, entity.getTitle());
            ps.setInt(2, entity.getCourseId());
            ps.setInt(3, entity.getId());
        });
    }

    @Override
    public boolean remove(Outline entity){
        LOG.debug("Delete outline: " + entity);
        return createUpdate(DELETE_OUTLINE, ps -> ps.setInt(1, entity.getId()));
    }

}
