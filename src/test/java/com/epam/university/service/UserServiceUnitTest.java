package com.epam.university.service;

import com.epam.university.dao.EntityDao;
import com.epam.university.entity.User;
import com.epam.university.web.form.RegistrationForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest {

    private static final String USER_LOGIN = "user login";
    private static final String USER_PASSWORD = "user password";
    private static final String INVALID_PASSWORD = "invalid password";
    private static final String INVALID_LOGIN = "invalid login";
    
    @InjectMocks
    private UserService instance;

    @Mock
    private EntityDao<User> userDao;
    @Mock
    private User user;
    private RegistrationForm registrationForm = new RegistrationForm();

    @Before
    public void setUp() {
        when(userDao.getAll()).thenReturn(Collections.singletonList(user));
        when(user.getLogin()).thenReturn(USER_LOGIN);
        when(user.getPassword()).thenReturn(USER_PASSWORD);

        registrationForm.setLogin(USER_LOGIN);
    }

    @Test
    public void shouldReturnUserWhenLoginAndPasswordValid() {
        Optional<User> result = instance.validateUser(USER_LOGIN, USER_PASSWORD);

        assertThat(result).isNotEmpty();
        assertThat(result.get()).isEqualTo(user);
    }

    @Test
    public void shouldReturnEmptyWhenInvalidPassword() {
        Optional<User> result = instance.validateUser(USER_LOGIN, INVALID_PASSWORD);

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnEmptyWhenInvalidLogin() {
        Optional<User> result = instance.validateUser(INVALID_LOGIN, USER_PASSWORD);

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnUserWhenLoginValid() {
        Optional<User> result = instance.findByLogin(USER_LOGIN);

        assertThat(result).isNotEmpty();
        assertThat(result.get()).isEqualTo(user);
    }

    @Test
    public void shouldReturnEmptyWhenInvalidLoginFind() {
        Optional<User> result = instance.findByLogin(INVALID_LOGIN);

        assertThat(result).isEmpty();
    }

    @Test
    public void shouldReturnTrueWhenUserExist() {
        boolean result = instance.isExist(USER_LOGIN);

        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenUserNotExist() {
        boolean result = instance.isExist(INVALID_LOGIN);

        assertThat(result).isFalse();
    }

    @Test
    public void shouldReturnUserWhenCreateSuccess() {
        when(userDao.create(any(User.class))).thenReturn(Boolean.TRUE);

        Optional<User> result = instance.createUser(registrationForm);

        assertThat(result).isNotEmpty();
        assertThat(result.get()).isEqualTo(user);
    }

    @Test
    public void shouldReturnEmptyWhenCreateFail() {
        when(userDao.create(any(User.class))).thenReturn(Boolean.FALSE);

        Optional<User> result = instance.createUser(registrationForm);

        assertThat(result).isEmpty();
    }
}