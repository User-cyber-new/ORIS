package org.example.dao;

import org.example.entities.Course;

import java.util.List;

public interface EntityDao<T> {
    T findById(int id);
    List<T> findAll();
    void save(T t);
    void update(T t);
    void delete(int id);

    // в delete передаю int - bad
}
