package org.example.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.CourseService;

import java.io.IOException;

@WebServlet("/add-courses-admin")
public class AddCourseServlet extends HttpServlet {
    private CourseService courseService = new CourseService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("course-name");
        Integer price = Integer.valueOf(req.getParameter("price"));

        courseService.createCourse(name, price);

        resp.sendRedirect("/semestr1/courses-changes");
    }
}
