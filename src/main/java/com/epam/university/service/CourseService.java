package com.epam.university.service;

import com.epam.university.dao.EntityDao;
import com.epam.university.dto.CourseDTO;
import com.epam.university.dto.UserDTO;
import com.epam.university.entity.Course;
import com.epam.university.entity.User;
import com.epam.university.enums.DaoType;
import com.epam.university.factory.DaoFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {

    private EntityDao<User> userDao;
    private EntityDao<Course> subjectDao;

    public CourseService() {
        this.userDao = DaoFactory.getEntityDao(DaoType.USER);
        this.subjectDao = DaoFactory.getEntityDao(DaoType.SUBJECT);
    }

    public List<CourseDTO> getAll() {
        List<Course> all = subjectDao.getAll(true);
        return all.stream().map(course -> {
            User lecturer = userDao.getById(course.getLecturerId(), false);
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setTitle(course.getTitle());
            courseDTO.setDescription(course.getDescription());

            UserDTO lecturerDTO = new UserDTO();
            lecturerDTO.setId(lecturer.getId());
            lecturerDTO.setName(lecturer.getFirstName() + " " + lecturer.getLastName());
            courseDTO.setLecturer(lecturerDTO);
            return courseDTO;
        }).collect(Collectors.toList());
    }
}
