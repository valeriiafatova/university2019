package com.epam.university.web.command;

import com.epam.university.entity.User;
import com.epam.university.service.UserService;
import com.epam.university.web.data.Page;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginCommandUnitTest {

    private static final String USER_LOGIN = "user login";
    private static final String USER_PASSWORD = "user password";
    
    @InjectMocks
    private LoginCommand instance;

    @Mock
    private UserService userService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;
    @Mock
    private User user;

    @Before
    public void setUp() {
        when(request.getParameter("login")).thenReturn(USER_LOGIN);
        when(request.getParameter("password")).thenReturn(USER_PASSWORD);
        when(request.getSession()).thenReturn(session);
        when(userService.validateUser(USER_LOGIN, USER_PASSWORD)).thenReturn(Optional.of(user));
    }

    @Test
    public void shouldAddUserToSessionWhenValidUser() {
        instance.performPost(request);

        verify(session).setAttribute("user", user);
    }

    @Test
    @Ignore
    public void shouldAddErrorToSessionWhenNotValidUser() {
        when(userService.validateUser(USER_LOGIN, USER_PASSWORD)).thenReturn(Optional.empty());

        instance.performPost(request);

        verify(session, never()).setAttribute("user", user);
        verify(session).setAttribute(eq("error"), anyString());
    }

    @Test
    @Ignore
    public void shouldRedirectToHome() {
        Page result = instance.performPost(request);

        assertThat(result.getUrl()).isEqualTo("/");
        assertThat(result.isRedirect()).isTrue();
    }
}
