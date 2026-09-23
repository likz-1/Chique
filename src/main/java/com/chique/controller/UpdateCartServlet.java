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

@WebServlet("/update-cart")

public class UpdateCartServlet
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

            String action =
                    request.getParameter(
                            "action");

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

                if(action.equals(
                        "increase")) {

                    boolean stockReduced =
                            variantDAO.reduceStock(
                                    variantId,
                                    1);

                    if(stockReduced){

                        item.setQuantity(
                                item.getQuantity() + 1);
                    }
                }

                else if(action.equals(
                        "decrease")) {

                    if(item.getQuantity() > 1){

                        item.setQuantity(
                                item.getQuantity() - 1);

                        variantDAO.increaseStock(
                                variantId,
                                1);
                    }
                }

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