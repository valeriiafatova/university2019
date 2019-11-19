package com.epam.university.web.command;

import com.epam.university.web.data.Page;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LanguageCommandUnitTest {
    private static final String LOCALE = "locale";
    private static final String LOCALE_PARAM = "locale param";

    @InjectMocks
    private LanguageCommand instance;

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpSession session;

    @Before
    public void setUp() {
        when(request.getSession()).thenReturn(session);
    }

    @Test
    public void shouldSetLocaleToSessionWhenParamNotEmpty() {
        when(request.getParameter(LOCALE)).thenReturn(LOCALE_PARAM);

        instance.perform(request);

        verify(session).setAttribute(LOCALE, LOCALE_PARAM);
    }

    @Test
    public void shouldNotSetLocaleToSessionWhenParamEmpty() {
        when(request.getParameter(LOCALE)).thenReturn(null);

        instance.perform(request);

        verify(session, never()).setAttribute(LOCALE, LOCALE_PARAM);
    }

    @Test
    public void shouldRedirectToHome() {
        when(request.getParameter(LOCALE)).thenReturn(LOCALE_PARAM);

        Page result = instance.perform(request);

        assertThat(result.getUrl()).isEqualTo("/");
        assertThat(result.isRedirect()).isTrue();
    }
}
