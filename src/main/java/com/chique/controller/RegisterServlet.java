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

@WebServlet("/register")

public class RegisterServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        request.setCharacterEncoding(
                "UTF-8");

        String fullName =
                request.getParameter(
                        "fullName");

        String email =
                request.getParameter(
                        "email");

        String phone =
                request.getParameter(
                        "phone");

        String password =
                request.getParameter(
                        "password");

        String address1 =
                request.getParameter(
                        "address1");

        String address2 =
                request.getParameter(
                        "address2");

        String city =
                request.getParameter(
                        "city");

        String state =
                request.getParameter(
                        "state");

        String pincode =
                request.getParameter(
                        "pincode");

        String country =
                request.getParameter(
                        "country");

        User user =
                new User();

        user.setFullName(
                fullName);

        user.setEmail(
                email);

        user.setPhone(
                phone);

        user.setPassword(
                password);

        user.setAddressLine1(
                address1);

        user.setAddressLine2(
                address2);

        user.setCity(
                city);

        user.setState(
                state);

        user.setPincode(
                pincode);

        user.setCountry(
                country);

        UserDAO userDAO =
                new UserDAOImpl();

        boolean status =
                userDAO.registerUser(
                        user);

        if(status) {

            response.sendRedirect(
                    "login.jsp");

        } else {

            response.sendRedirect(
                    "register.jsp");
        }
    }
}