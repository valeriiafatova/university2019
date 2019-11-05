package com.epam.university.web.command;

import com.epam.university.dao.EntityDao;
import com.epam.university.entity.User;
import com.epam.university.enums.DaoType;
import com.epam.university.factory.DaoFactory;
import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

public class UserCommand implements Command{
    private EntityDao<User> userDao;

    public UserCommand() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
    }

    @Override
    public Page perform(HttpServletRequest request) {
        long userCount = userDao.getAll().stream().count();
        request.setAttribute("count", userCount);
        return new Page("/user.jsp");
    }

    public void setUserDao(EntityDao userDao) {
        this.userDao = userDao;
    }
}
