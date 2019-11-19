package com.epam.university.web.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LogoutCommandUnitTest {

    @InjectMocks
    private LogoutCommand instance;

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;

    @Test
    public void shouldInvalidateSession() {
        when(request.getSession()).thenReturn(session);

        instance.perform(request);

        verify(session).invalidate();
    }
}
