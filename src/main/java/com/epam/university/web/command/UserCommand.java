package com.epam.university.web.command;

import com.epam.university.dao.EntityDao;
import com.epam.university.entity.User;
import com.epam.university.enums.DaoType;
import com.epam.university.factory.DaoFactory;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.USER_PAGE;

public class UserCommand implements Command{
    private static final String COUNT_ATTRIBUTE = "count";
    private EntityDao<User> userDao;

    public UserCommand() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
    }

    @Override
    public Page perform(HttpServletRequest request) {
        long userCount = userDao.getAll().stream().count();
        request.setAttribute(COUNT_ATTRIBUTE, userCount);
        return new Page(USER_PAGE);
    }

    public void setUserDao(EntityDao userDao) {
        this.userDao = userDao;
    }
}
