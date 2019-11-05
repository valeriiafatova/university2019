package com.epam.university.web.command;

import com.epam.university.dao.EntityDao;
import com.epam.university.entity.User;
import com.epam.university.web.data.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import javax.servlet.http.HttpServletRequest;

import java.util.Collections;

import static com.epam.university.constant.PageUrlConstants.USER_PAGE;
import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class UserCommandUnitTest {

    @InjectMocks
    private UserCommand instance;
    
    @Mock
    private EntityDao<User> userDao;
    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldReturnUserPage() {
        Mockito.when(userDao.getAll()).thenReturn(Collections.singletonList(new User()));
        
        Page result = instance.perform(request);
        
        assertThat(result.getUrl()).isEqualTo(USER_PAGE);
        assertThat(result.isRedirect()).isFalse();
        Mockito.verify(request).setAttribute("count", 1L);
    }
}