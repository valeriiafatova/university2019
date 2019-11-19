package com.epam.university.web.command;

import com.epam.university.entity.User;
import com.epam.university.enums.Role;
import com.epam.university.service.UserService;
import com.epam.university.web.data.Page;
import com.epam.university.web.form.RegistrationForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static com.epam.university.constant.PageUrlConstants.REGISTER_PAGE;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationCommandUnitTest {

    private static final String LOGIN_PARAM = "login param";
    private static final String FIRST_NAME_PARAM = "firstName param";
    private static final String LAST_NAME_PARAM = "lastName param";
    private static final String PASSWORD_PARAM = "password param";
    private static final String INVALID_PASSWORD_CONFIRM_PARAM = "invalid password confirm param";

    @InjectMocks
    private RegistrationCommand instance;

    @Mock
    private UserService userService;

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;
    private RegistrationForm registrationForm = new RegistrationForm();
    @Mock
    private User user;

    @Before
    public void setUp() {
        registrationForm.setLogin(LOGIN_PARAM);
        registrationForm.setFirstName(FIRST_NAME_PARAM);
        registrationForm.setLastName(LAST_NAME_PARAM);
        registrationForm.setPassword(PASSWORD_PARAM);
        registrationForm.setPasswordConfirm(PASSWORD_PARAM);
        registrationForm.setRole(Role.STUDENT);

        when(request.getParameter("login")).thenReturn(LOGIN_PARAM);
        when(request.getParameter("first_name")).thenReturn(FIRST_NAME_PARAM);
        when(request.getParameter("last_name")).thenReturn(LAST_NAME_PARAM);
        when(request.getParameter("password")).thenReturn(PASSWORD_PARAM);
        when(request.getParameter("password_confirm")).thenReturn(PASSWORD_PARAM);
        when(request.getSession()).thenReturn(session);

        when(userService.isExist(LOGIN_PARAM)).thenReturn(Boolean.FALSE);
        when(userService.createUser(refEq(registrationForm))).thenReturn(Optional.of(user));
    }

    @Test
    public void shouldAddUserToSessionWhenUserCreated() {

        Page result = instance.performPost(request);

        verify(session).setAttribute("user", user);
        assertThat(result.getUrl()).isEqualTo("/");
        assertThat(result.isRedirect()).isTrue();
    }

    @Test
    public void shouldSetErrorWhenUserExist() {
        when(userService.isExist(LOGIN_PARAM)).thenReturn(Boolean.TRUE);

        Page result = instance.performPost(request);

        verify(request).setAttribute("error", "User already exist");
        assertThat(result.getUrl()).isEqualTo(REGISTER_PAGE);

    }

    @Test
    public void shouldSetErrorWhenFormInvalid() {
        when(request.getParameter("password_confirm")).thenReturn(INVALID_PASSWORD_CONFIRM_PARAM);

        Page result = instance.performPost(request);

        verify(request).setAttribute("error", "Invalid form");
        assertThat(result.getUrl()).isEqualTo(REGISTER_PAGE);
    }

    @Test
    public void shouldSetErrorWhenUserNotCreate() {
        when(userService.createUser(any(RegistrationForm.class))).thenReturn(Optional.empty());

        Page result = instance.performPost(request);

        verify(request).setAttribute("error", "Could not create user");
        assertThat(result.getUrl()).isEqualTo(REGISTER_PAGE);
    }

}
