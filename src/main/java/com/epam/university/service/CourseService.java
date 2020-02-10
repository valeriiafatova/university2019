package com.epam.university.service;

import com.epam.university.dao.EntityDao;
import com.epam.university.dto.CourseDTO;
import com.epam.university.dto.UserDTO;
import com.epam.university.entity.Course;
import com.epam.university.entity.Rating;
import com.epam.university.entity.User;
import com.epam.university.enums.DaoType;
import com.epam.university.factory.DaoFactory;
import com.sun.xml.internal.rngom.digested.DGrammarPattern;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseService {

    private EntityDao<User> userDao;
    private EntityDao<Course> courseDao;
    private EntityDao<Rating> ratingDao;

    public CourseService() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
        this.courseDao = DaoFactory.getEntityDao(DaoType.COURSE);
        this.ratingDao = DaoFactory.getEntityDao(DaoType.RATING);
    }

    public List<CourseDTO> getAll() {
        List<Course> all = courseDao.getAll(true);
        return all.stream().map(this::mapCourseDTO).collect(Collectors.toList());
    }

    public Optional<CourseDTO> getById(int id) {
        Course course = courseDao.getById(id, true);
        return course != null ? Optional.of(mapCourseDTO(course)) : Optional.empty();
    }

    private CourseDTO mapCourseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDescription(course.getDescription());

        if (course.getLecturerId() != 0) {
            courseDTO.setLecturer(mapLecturer(course.getLecturerId()));
        }
        return courseDTO;
    }

    private UserDTO mapLecturer(int lecturerId) {
        User lecturer = userDao.getById(lecturerId, false);
        UserDTO lecturerDTO = new UserDTO();
        lecturerDTO.setId(lecturer.getId());
        lecturerDTO.setName(lecturer.getFirstName() + " " + lecturer.getLastName());
        return lecturerDTO;
    }
}
