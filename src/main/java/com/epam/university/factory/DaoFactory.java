package com.epam.university.factory;

import com.epam.university.dao.CourseDao;
import com.epam.university.dao.EntityDao;
import com.epam.university.dao.OutlineDao;
import com.epam.university.dao.RatingDao;
import com.epam.university.dao.UserDao;
import com.epam.university.enums.DaoType;

import java.util.HashMap;
import java.util.Map;

public class DaoFactory {
    
    private static Map<DaoType, EntityDao> daoMap = new HashMap<>();
    
    static {
        daoMap.put(DaoType.USER, new UserDao());
        daoMap.put(DaoType.SUBJECT, new CourseDao());
        daoMap.put(DaoType.MAJOR, new OutlineDao());
        daoMap.put(DaoType.RATING, new RatingDao());
    }
    
    private DaoFactory() {
    }
    
    public static EntityDao getEntityDao(DaoType daoType){
        EntityDao entityDao = daoMap.get(daoType);
        if(entityDao != null ){
            return entityDao;
        }
        throw new RuntimeException("Dao with current dao type do not exist: " + daoType.name());
    }
    
}
