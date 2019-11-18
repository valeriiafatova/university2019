package com.epam.university.service;

import com.epam.university.dao.EntityDao;
import com.epam.university.entity.User;
import com.epam.university.enums.DaoType;
import com.epam.university.factory.DaoFactory;

import java.util.List;
import java.util.Optional;

public class UserService {
    private EntityDao<User> userDao;

    public UserService() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
    }
    
    public int validateUser(String login, String password){
        List<User> all = userDao.getAll();

        User user = all.stream().filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findFirst().orElseGet(() -> new User());
        return user.getId();
    }
    
    public User getUser(int id){
        return userDao.getById(id, false);
    }
}
