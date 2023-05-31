package com.example.onlinestore;

import java.io.*;

import com.example.onlinestore.service.CustomerService;
import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @EJB
    private CustomerService customerService;


    public void init() {


        message = "Hello World!";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        customerService.create(new com.example.onlinestore.entity.Customer("rachidi", "yacine", "email"));
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>ok " + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {

    }
}