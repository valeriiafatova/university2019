package com.epam.university.dao;

import com.epam.university.entity.User;
import com.epam.university.enums.Role;
import org.apache.log4j.Logger;

import java.util.List;

public class UserDao extends AbstractDao<User>{
    private static final Logger LOG = Logger.getLogger(UserDao.class);
    
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ROLE = "role";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_LAST_NAME = "last_name";
    
    private static final String SELECT_ALL_USERS = "SELECT * FROM `user`";
    
    private static final String INSERT_INTO_USER = "INSERT INTO `user` ("
            + COLUMN_LOGIN + ", "
            + COLUMN_PASSWORD + ", "
            + COLUMN_ROLE + ", "
            + COLUMN_FIRST_NAME + ", "
            + COLUMN_LAST_NAME + ") VALUE (?, ?, ?, ?, ?)";

    private static final String UPDATE_USER = "UPDATE `user` "
            + COLUMN_LOGIN + "= ?, "
            + COLUMN_PASSWORD + "= ?, "
            + COLUMN_ROLE + "= ?, "
            + COLUMN_FIRST_NAME + "= ?, "
            + COLUMN_LAST_NAME + "= ? WHERE "
            + COLUMN_ID + " = ?";
   
    private static final String DELETE_USER = "DELETE FROM `user` "
            + "WHERE " + COLUMN_ID + " = ?";

    @Override
    public User getById(int id, boolean full) {
        return getById("SELECT * FROM `user` WHERE id = ?", 
                ps -> ps.setInt(1, id), 
                getMapper());
    }

    @Override
    public List<User> getAll(){
        return getAll(SELECT_ALL_USERS, getMapper());
    }

    private EntityMapper<User> getMapper() {
        return resultSet -> new User(resultSet.getInt(COLUMN_ID), 
                resultSet.getString(COLUMN_LOGIN), resultSet.getString(COLUMN_PASSWORD),
                Role.valueOf(resultSet.getString(COLUMN_ROLE)),
                resultSet.getString(COLUMN_FIRST_NAME),
                resultSet.getString(COLUMN_LAST_NAME));
    }

    @Override
    public boolean create(User entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_USER, ps -> {
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getRole().toString());
            ps.setString(4, entity.getFirstName());
            ps.setString(5, entity.getLastName());
        });
    }

    @Override
    public boolean update(User entity) {
        LOG.debug("Update user: " + entity);
        return createUpdate(UPDATE_USER, ps -> {
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getRole().toString());
            ps.setString(4, entity.getFirstName());
            ps.setString(5, entity.getLastName());
            ps.setInt(6, entity.getId());
        });    
    }
    
    @Override
    public boolean remove(User entity){
        LOG.debug("Delete user: " + entity);
        return createUpdate(DELETE_USER, ps -> ps.setInt(1, entity.getId()));
    }
}
