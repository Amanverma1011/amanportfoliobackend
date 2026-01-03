package com.aman.portfolio.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.portfolio.dao.ContactDAO;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        if (name == null || email == null || message == null ||
            name.isEmpty() || email.isEmpty() || message.isEmpty()) {

            response.sendRedirect("index.html?status=error");
            return;
        }

        ContactDAO dao = new ContactDAO();
        boolean saved = dao.saveMessage(name, email, message);

        if (saved) {
            response.sendRedirect("index.html?status=success");
        } else {
            response.sendRedirect("index.html?status=error");
        }
    }
}
