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
    private static final String SELECT_ALL_USERS = "SELECT * FROM `user`";
    
    private static final String INSERT_INTO_USER = "INSERT INTO `user` ("
            + COLUMN_LOGIN + ", "
            + COLUMN_PASSWORD + ", "
            + COLUMN_ROLE + ") VALUE (?, ?, ?, ?)";

    private static final String UPDATE_USER = "UPDATE `user` "
            + COLUMN_LOGIN + "= ?, "
            + COLUMN_PASSWORD + "= ?, "
            + COLUMN_ROLE + "= ? WHERE "
            + COLUMN_ID + " = ?";
   
    private static final String DELETE_USER = "DELETE FROM `user` "
            + "WHERE " + COLUMN_ID + " = ?";
    
    @Override
    public List<User> getAll(){
        return getAll(SELECT_ALL_USERS, resultSet -> new User(resultSet.getInt(COLUMN_ID), 
                resultSet.getString(COLUMN_LOGIN), resultSet.getString(COLUMN_PASSWORD),
                Role.valueOf(resultSet.getString(COLUMN_ROLE))));
    }

    @Override
    public boolean create(User entity) {
        LOG.debug("Create user: + " + entity);
        return createUpdate(INSERT_INTO_USER, ps -> {
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getRole().toString());
        });
    }

    @Override
    public boolean update(User entity) {
        LOG.debug("Update user: " + entity);
        return createUpdate(UPDATE_USER, ps -> {
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getRole().toString());
            ps.setInt(4, entity.getId());
        });    
    }
    
    @Override
    public boolean remove(User entity){
        LOG.debug("Delete user: " + entity);
        return createUpdate(DELETE_USER, ps -> ps.setInt(1, entity.getId()));
    }
}
