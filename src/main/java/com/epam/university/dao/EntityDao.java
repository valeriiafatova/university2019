package com.epam.university.dao;

import java.util.List;

public interface EntityDao<T> {
    
    List<T> getAll();
}
