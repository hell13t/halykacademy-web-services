package org.example;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/user")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String position = request.getParameter("position");

        response.getWriter().println("Employee name: " + name + ", position: " + position);

    }

    public void destroy() {
    }
}