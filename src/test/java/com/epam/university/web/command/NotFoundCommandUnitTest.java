package com.epam.university.web.command;

import com.epam.university.web.data.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.NOT_FOUND_PAGE;
import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class NotFoundCommandUnitTest {

    @InjectMocks
    private NotFoundCommand instance;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnNotFoundPage() {
        Page result = instance.perform(request);
        
        assertThat(result.getUrl()).isEqualTo(NOT_FOUND_PAGE);
        assertThat(result.isRedirect()).isTrue();
    }
}