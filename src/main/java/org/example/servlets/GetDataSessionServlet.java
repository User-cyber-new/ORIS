package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.entities.Course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/get_data_session")
public class GetDataSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        List<Course> courses = (List<Course>) session.getAttribute("courses");
        for (Course course : courses) {
            out.println(course);
        }

    }
}
