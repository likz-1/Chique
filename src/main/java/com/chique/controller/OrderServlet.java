package com.chique.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.chique.dao.OrderDAO;
import com.chique.dao.OrderItemDAO;
import com.chique.dao.ProductVariantDAO;

import com.chique.daoimpl.OrderDAOImpl;
import com.chique.daoimpl.OrderItemDAOImpl;
import com.chique.daoimpl.ProductVariantDAOImpl;

import com.chique.model.CartItem;
import com.chique.model.Order;
import com.chique.model.OrderItem;
import com.chique.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/place-order")

public class OrderServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        try {

            HttpSession session =
                    request.getSession();

            User loggedInUser =
                    (User) session.getAttribute(
                            "loggedInUser");

            if(loggedInUser == null) {

                response.sendRedirect(
                        "login.jsp");

                return;
            }

            ArrayList<CartItem> cart =
                    (ArrayList<CartItem>)
                    session.getAttribute(
                            "cart");

            if(cart == null || cart.isEmpty()) {

                response.sendRedirect(
                        "cart.jsp");

                return;
            }

            double total = 0;

            for(CartItem item : cart) {

                total += item.getPrice()
                        * item.getQuantity();
            }

            String address =
                    request.getParameter(
                            "address");

            String city =
                    request.getParameter(
                            "city");

            String pincode =
                    request.getParameter(
                            "pincode");

            String fullAddress =
                    address + ", "
                    + city + " - "
                    + pincode;

            Order order =
                    new Order();

            order.setUserId(
                    loggedInUser.getUserId());

            order.setTotalAmount(
                    BigDecimal.valueOf(total));

            order.setPaymentMethod(
                    "Card");

            order.setPaymentStatus(
                    "Completed");

            order.setOrderStatus(
                    "Placed");

            order.setShippingAddress(
                    fullAddress);

            OrderDAO orderDAO =
                    new OrderDAOImpl();

            boolean status =
                    orderDAO.placeOrder(
                            order);

            if(status) {

                OrderItemDAO orderItemDAO =
                        new OrderItemDAOImpl();

                ProductVariantDAO variantDAO =
                        new ProductVariantDAOImpl();

                for(CartItem item : cart) {

                    int variantId =
                            variantDAO
                            .getVariantIdByProductAndSize(
                                    item.getProductName(),
                                    item.getSize());

                    OrderItem orderItem =
                            new OrderItem();

                    orderItem.setOrderId(
                            order.getOrderId());

                    orderItem.setVariantId(
                            variantId);

                    orderItem.setQuantity(
                            item.getQuantity());

                    orderItem.setPrice(
                            BigDecimal.valueOf(
                                    item.getPrice()));

                    orderItemDAO.addOrderItem(
                            orderItem);
                }

                session.removeAttribute(
                        "cart");

                response.sendRedirect(
                        "order-success.jsp");
            }

            else {

                response.sendRedirect(
                        "checkout.jsp");
            }

        }

        catch(Exception e) {

            e.printStackTrace();

            response.sendRedirect(
                    "checkout.jsp");
        }
    }
}