package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.Utils;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/enter")
public class MainServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String message = req.getParameter("message");

        PrintWriter out = resp.getWriter();
        if (Utils.isEmail(email)) {
            out.println("<h1>ввод данных прошел успешно</h1>");

            out.println(
            """
                <form action="getdata" method="post">
                                <input type="hidden" name="login" value="%s">
                                <input type="hidden" name="email" value="%s">
                                <input type="hidden" name="password" value="%s">
                                <input type="hidden" name="message" value="%s">
                                <button type="submit" name="action" value="download">Получить текстовый файл с данными</button>
                </form>
            """.formatted(login, email, password, message)
            );

            out.println(login);
            out.println(email);
            out.println(password);
            out.println(message);
        }

        else {
            out.println("неверно введен email");
        }

    }

}
