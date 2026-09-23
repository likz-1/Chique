package com.chique.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class Order {

    private int orderId;

    private int userId;

    private BigDecimal totalAmount;

    private String paymentMethod;

    private String paymentStatus;

    private String orderStatus;

    private String shippingAddress;

    private Timestamp orderDate;

    private List<CartItem> cartItems;

    // DEFAULT CONSTRUCTOR

    public Order() {

    }

    // PARAMETERIZED CONSTRUCTOR

    public Order(
            int orderId,
            int userId,
            BigDecimal totalAmount,
            String paymentMethod,
            String paymentStatus,
            String orderStatus,
            String shippingAddress,
            Timestamp orderDate) {

        this.orderId = orderId;

        this.userId = userId;

        this.totalAmount = totalAmount;

        this.paymentMethod = paymentMethod;

        this.paymentStatus = paymentStatus;

        this.orderStatus = orderStatus;

        this.shippingAddress = shippingAddress;

        this.orderDate = orderDate;
    }

    public int getOrderId() {

        return orderId;
    }

    public void setOrderId(
            int orderId) {

        this.orderId = orderId;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(
            int userId) {

        this.userId = userId;
    }

    public BigDecimal getTotalAmount() {

        return totalAmount;
    }

    public void setTotalAmount(
            BigDecimal totalAmount) {

        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {

        return paymentMethod;
    }

    public void setPaymentMethod(
            String paymentMethod) {

        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {

        return paymentStatus;
    }

    public void setPaymentStatus(
            String paymentStatus) {

        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {

        return orderStatus;
    }

    public void setOrderStatus(
            String orderStatus) {

        this.orderStatus = orderStatus;
    }

    public String getShippingAddress() {

        return shippingAddress;
    }

    public void setShippingAddress(
            String shippingAddress) {

        this.shippingAddress = shippingAddress;
    }

    public Timestamp getOrderDate() {

        return orderDate;
    }

    public void setOrderDate(
            Timestamp orderDate) {

        this.orderDate = orderDate;
    }

    public List<CartItem> getCartItems() {

        return cartItems;
    }

    public void setCartItems(
            List<CartItem> cartItems) {

        this.cartItems = cartItems;
    }
}