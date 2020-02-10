package com.epam.university.web.command;

import com.epam.university.dto.CourseDTO;
import com.epam.university.entity.User;
import com.epam.university.enums.Role;
import com.epam.university.factory.ServiceFactory;
import com.epam.university.security.SecurityConfig;
import com.epam.university.service.CourseService;
import com.epam.university.service.RatingService;
import com.epam.university.web.data.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

import static com.epam.university.constant.PageUrlConstants.COURSE_DETAILS_PAGE;
import static com.epam.university.constant.PageUrlConstants.COURSE_PAGE;

public class CourseCommand extends MultipleMethodCommand {
    private static final Logger LOG = Logger.getLogger(CourseCommand.class);
    public static final String ENROLL = "enroll";

    private CourseService courseService;
    private RatingService ratingService;

    public CourseCommand() {
        this.courseService = ServiceFactory.getCourseService();
        this.ratingService = ServiceFactory.getRatingService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        String courseId = request.getParameter("course_id");

        if (courseId != null) {
            return populateCoursePage(request, Integer.parseInt(courseId));
        }

        request.setAttribute("courses", courseService.getAll());
        return new Page(COURSE_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String type = request.getParameter("type");
        if (ENROLL.equals(type)) {
            boolean hasPermission = SecurityConfig.hasPermission(request, Role.STUDENT);
            if (hasPermission) {
                int courseId = Integer.parseInt(request.getParameter("course_id"));
                int userId = SecurityConfig.getCurrentUser(request).getId();

                boolean result = ratingService.enrollToCourse(courseId, userId);
                if (result) {
                    request.setAttribute("result", "Success enrollment");
                } else {
                    request.setAttribute("result", "Fail enrollment, sorry");
                }
                
                populateCourse(request, courseId);

                return new Page(COURSE_DETAILS_PAGE);
            } else {
                return new Page("/registration", true);
            }
        }
        return null;
    }

    private Page populateCoursePage(HttpServletRequest request, int courseId) {

        populateCourse(request, courseId);

        populateAlreadyEnrolled(request, courseId);
        
        return new Page(COURSE_DETAILS_PAGE);
    }

    private void populateCourse(HttpServletRequest request, int courseId) {
        LOG.debug("Search course with courseId : " + courseId);

        Optional<CourseDTO> course = courseService.getById(courseId);
        if (course.isPresent()) {
            request.setAttribute("course", course.get());
        } else {
            request.setAttribute("error", "Course not exist");
        }
    }

    private void populateAlreadyEnrolled(HttpServletRequest request, int courseId) {
        User currentUser = SecurityConfig.getCurrentUser(request);
        if (currentUser != null) {
            int userId = currentUser.getId();

            boolean alreadyEnrolled = ratingService.isAlreadyEnrolled(courseId, userId);
            if (!alreadyEnrolled) {
                request.setAttribute("canEnroll", true);
            }
        }else {
            request.setAttribute("canEnroll", true);
        }
    }


}
