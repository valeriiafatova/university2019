package com.epam.university.dao;

import com.epam.university.entity.User;
import com.epam.university.enums.Role;
import org.apache.log4j.Logger;

import java.util.List;

public class UserDao extends AbstractDao<User>{
    private static final Logger LOG = Logger.getLogger(UserDao.class);
    
    private static final String SELECT_ALL_USERS = "SELECT * FROM `user`";
    private static final String COLUMN_LOGIN = "login";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ROLE = "role";

    public UserDao() {
    }
    
    @Override
    public List<User> getAll(){
        return getAll(SELECT_ALL_USERS, resultSet -> new User(resultSet.getInt(COLUMN_ID), 
                resultSet.getString(COLUMN_LOGIN), resultSet.getString(COLUMN_PASSWORD),
                Role.valueOf(resultSet.getString(COLUMN_ROLE))));
    }
}
