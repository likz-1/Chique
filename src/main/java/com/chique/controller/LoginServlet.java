package com.chique.controller;

import java.io.IOException;

import com.chique.dao.UserDAO;
import com.chique.daoimpl.UserDAOImpl;
import com.chique.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")

public class LoginServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        try {

            String email =
                    request.getParameter(
                            "email");

            String password =
                    request.getParameter(
                            "password");

            String admin =
                    request.getParameter(
                            "admin");

            // ADMIN LOGIN

            if(email.equals("admin@gmail.com")
                    && password.equals("admin123")){

                HttpSession session =
                        request.getSession();

                session.setAttribute(
                        "admin",
                        true);

                response.sendRedirect(
                        "admin-dashboard.jsp");

                return;
            }

            // NORMAL USER LOGIN

            UserDAO userDAO =
                    new UserDAOImpl();

            User user =
                    userDAO.loginUser(
                            email,
                            password);

            if(user != null){

                HttpSession session =
                        request.getSession();

                session.setAttribute(
                        "loggedInUser",
                        user);

                response.sendRedirect(
                        "index.jsp");
            }

            else{

                response.sendRedirect(
                        "login.jsp");
            }

        }

        catch(Exception e){

            e.printStackTrace();

            response.sendRedirect(
                    "login.jsp");
        }
    }
}