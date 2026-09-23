package com.chique.controller;

import java.io.IOException;

import com.chique.dao.ProductDAO;
import com.chique.daoimpl.ProductDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete-product")

public class DeleteProductServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        Boolean admin =
                (Boolean) session.getAttribute(
                        "admin");

        if(admin == null || !admin){

            response.sendRedirect(
                    "login.jsp");

            return;
        }

        int productId =
                Integer.parseInt(
                        request.getParameter(
                                "productId"));

        ProductDAO productDAO =
                new ProductDAOImpl();

        boolean status =
                productDAO.deleteProduct(
                        productId);

        if(status) {

            response.sendRedirect(
                    "manage-products.jsp");
        }

        else {

            response.getWriter().println(
                    "Failed to Delete Product");
        }
    }
}