package com.chique.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.chique.dao.ProductVariantDAO;
import com.chique.daoimpl.ProductVariantDAOImpl;
import com.chique.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/remove-cart-item")

public class RemoveCartItemServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        try {

            int index =
                    Integer.parseInt(
                            request.getParameter(
                                    "index"));

            HttpSession session =
                    request.getSession();

            ArrayList<CartItem> cart =
                    (ArrayList<CartItem>)
                    session.getAttribute(
                            "cart");

            if(cart != null
                    && index >= 0
                    && index < cart.size()) {

                CartItem item =
                        cart.get(index);

                ProductVariantDAO variantDAO =
                        new ProductVariantDAOImpl();

                int variantId =
                        variantDAO
                        .getVariantIdByProductAndSize(
                                item.getProductName(),
                                item.getSize());

                variantDAO.increaseStock(
                        variantId,
                        item.getQuantity());

                cart.remove(index);

                session.setAttribute(
                        "cart",
                        cart);
            }

            response.sendRedirect(
                    "cart.jsp");
        }

        catch(Exception e){

            e.printStackTrace();

            response.sendRedirect(
                    "cart.jsp");
        }
    }
}