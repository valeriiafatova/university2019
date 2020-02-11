package com.epam.university.service;

import com.epam.university.dao.EntityDao;
import com.epam.university.entity.Rating;
import com.epam.university.enums.DaoType;
import com.epam.university.factory.DaoFactory;


public class RatingService {
    private EntityDao<Rating> ratingDao;

    public RatingService() {
        this.ratingDao = DaoFactory.getEntityDao(DaoType.RATING);
    }
    
    public boolean isAlreadyEnrolled(int courseId, int userId){
        return ratingDao.getAll().stream()
                .anyMatch(rating -> rating.getCourseId() == courseId && rating.getStudentId() == userId);
    }

    public boolean enrollToCourse(int courseId, int userId) {
        return ratingDao.create(new Rating(userId, courseId));
    }

}
