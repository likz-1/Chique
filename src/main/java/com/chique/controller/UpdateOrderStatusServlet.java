package com.chique.controller;

import java.io.IOException;

import com.chique.dao.OrderDAO;
import com.chique.daoimpl.OrderDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-order-status")

public class UpdateOrderStatusServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        int orderId =
                Integer.parseInt(
                        request.getParameter(
                                "orderId"));

        String orderStatus =
                request.getParameter(
                        "orderStatus");

        OrderDAO orderDAO =
                new OrderDAOImpl();

        orderDAO.updateOrderStatus(
                orderId,
                orderStatus);

        response.sendRedirect(
                "admin-orders.jsp");
    }
}