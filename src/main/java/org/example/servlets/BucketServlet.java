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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bucket")
public class BucketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer price = Integer.parseInt(req.getParameter("price"));

        Course course = new Course(id, name, price);

        List<Course> courses = (List<Course>) session.getAttribute("courses");

        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        session.setAttribute("courses", courses);

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<h1>корзина</h1>");
        for (Course c: courses) {
            out.println("""
                        <h2>%s</h2>
                    """.formatted(c.toString()));
        }

        out.println("""
                    <form action="get_data_session" method="get">
                        <button type="submit" name="action" value="download">Получить текстовый файл с данными</button>
                    </form>
                """);

        //resp.sendRedirect("get_data_session");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
