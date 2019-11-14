package com.epam.university.web.command;

import com.epam.university.web.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.epam.university.constant.PageUrlConstants.COURSE_DETAILS_PAGE;

public class CourseDetailsCommand  implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(COURSE_DETAILS_PAGE);
    }
}
