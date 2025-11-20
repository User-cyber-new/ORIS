package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.CourseService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update-courses-admin")
public class UpdateCourseServlet extends HttpServlet {
    CourseService courseService = new CourseService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("course-id"));
        Integer price = Integer.valueOf(req.getParameter("price"));


        if(courseService.updateCourse(id, price)){
            resp.sendRedirect("/semestr1/courses-changes");
        }
        else{
            resp.setContentType("text/html; charset=UTF-8");

            PrintWriter out = resp.getWriter();
            out.println("""
                    <p>курс, который вы хотите обновить, не существует или удален<p>
                    """);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
