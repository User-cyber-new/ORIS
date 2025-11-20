package org.example.service;

import org.example.dao.EntityDao;
import org.example.dao.impl.CourseDAO;
import org.example.entities.Course;

import java.util.List;

public class CourseService {
    private EntityDao entityDao;

    public CourseService() {
        this.entityDao = new CourseDAO();
    }

    public Course createCourse(String name, Integer price) {
        Course course = new Course(name, price);

        if (name!= null){
            entityDao.save(course);
        }
        return course;
    }

    public boolean deleteCourse(Integer id) {
        if (entityDao.findById(id) != null) {
            entityDao.delete(id);
            return true;
        }
        return false;
    }

    public boolean updateCourse(Integer id, Integer price) {
        Course course = new Course(id, price);

        if (entityDao.findById(id) != null) {
            entityDao.update(course);
            return true;
        }
        return false;
    }

    public List<Course> getAllCourses() {
        return entityDao.findAll();
    }
}
