package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.Course;
import org.example.service.CourseService;

import java.io.IOException;
import java.util.List;

@WebServlet("/courses-changes")
public class GetCoursesListServlet extends HttpServlet {
    CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        List<Course> courses = courseService.getAllCourses();

        try {
            req.setAttribute("courses", courses);
            req.getRequestDispatcher("/jsp/courses.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
