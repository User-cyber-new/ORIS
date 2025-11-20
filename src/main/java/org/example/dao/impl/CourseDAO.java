package org.example.dao.impl;

import org.example.DBFactory.DBFactory;
import org.example.dao.EntityDao;
import org.example.entities.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements EntityDao<Course> {

    private Connection conn;

    public CourseDAO() {
        conn = DBFactory.getConnection();
    }

    @Override
    public Course findById(int id) {
        String sql = "select * from courses where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price")
                );
            }
            else{
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> findAll() {
        String sql = "select * from courses";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Course> courses = new ArrayList<>();
            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price")
                ));
            }

            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(Course course) {
        String sql = "insert into courses (name, price) values (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getName());
            ps.setInt(2, course.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error in Course DAO");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(Course course) {
        String sql = "update courses set price = ? where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, course.getPrice());
            ps.setInt(2, course.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from courses where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CourseDAO().findAll());
    }
}