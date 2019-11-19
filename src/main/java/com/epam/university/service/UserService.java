package com.epam.university.service;

import com.epam.university.dao.EntityDao;
import com.epam.university.entity.User;
import com.epam.university.enums.DaoType;
import com.epam.university.enums.Role;
import com.epam.university.factory.DaoFactory;
import com.epam.university.web.form.RegistrationForm;
import com.epam.university.web.form.mapper.FormEntityMapper;

import java.util.List;
import java.util.Optional;

public class UserService {
    private EntityDao<User> userDao;
    private FormEntityMapper<User, RegistrationForm>  formEntityMapper 
            = form -> new User(0, form.getLogin(), form.getPassword(), form.getRole(),
            form.getFirstName(), form.getLastName());

    public UserService() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
    }

    public Optional<User> validateUser(String login, String password) {
        List<User> all = userDao.getAll();

        return all.stream().filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password)).findFirst();
    }

    public Optional<User> findByLogin(String login) {
        List<User> all = userDao.getAll();

        return all.stream().filter(u -> u.getLogin().equals(login)).findFirst();
    }

    public boolean isExist(String login) {
        List<User> all = userDao.getAll();

        return all.stream().anyMatch(u -> u.getLogin().equals(login));
    }

    public Optional<User> createUser(RegistrationForm registrationForm) {
        boolean result = userDao.create(formEntityMapper.map(registrationForm));
        
        return result ? findByLogin(registrationForm.getLogin()) : Optional.empty();
    }

    public User getUser(int id) {
        return userDao.getById(id, false);
    }
}
