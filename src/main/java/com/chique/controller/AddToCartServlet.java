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

@WebServlet("/add-to-cart")

public class AddToCartServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        try {

            String productName =
                    request.getParameter(
                            "productName");

            String size =
                    request.getParameter(
                            "size");

            double price =
                    Double.parseDouble(
                            request.getParameter(
                                    "price"));

            String image =
                    request.getParameter(
                            "image");

            ProductVariantDAO variantDAO =
                    new ProductVariantDAOImpl();

            int variantId =
                    variantDAO
                    .getVariantIdByProductAndSize(
                            productName,
                            size);

            // CHECK STOCK

            boolean stockReduced =
                    variantDAO.reduceStock(
                            variantId,
                            1);

            if(!stockReduced){

                response.sendRedirect(
                        "product.jsp?name="
                        + productName);

                return;
            }

            HttpSession session =
                    request.getSession();

            ArrayList<CartItem> cart =
                    (ArrayList<CartItem>)
                    session.getAttribute(
                            "cart");

            if(cart == null){

                cart = new ArrayList<>();
            }

            boolean itemExists = false;

            for(CartItem item : cart){

                if(item.getProductName()
                        .equals(productName)

                        &&

                        item.getSize()
                        .equals(size)){

                    item.setQuantity(
                            item.getQuantity() + 1);

                    itemExists = true;

                    break;
                }
            }

            if(!itemExists){

                CartItem item =
                        new CartItem();

                item.setProductName(
                        productName);

                item.setPrice(price);

                item.setImageUrl(image);

                item.setSize(size);

                item.setQuantity(1);

                cart.add(item);
            }

            session.setAttribute(
                    "cart",
                    cart);

            response.sendRedirect(
                    "cart.jsp");
        }

        catch(Exception e){

            e.printStackTrace();

            response.sendRedirect(
                    "product.jsp");
        }
    }
}