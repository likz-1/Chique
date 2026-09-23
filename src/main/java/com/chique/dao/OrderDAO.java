package com.chique.dao;

import java.util.List;

import com.chique.model.Order;

public interface OrderDAO {

	boolean placeOrder(Order order);

	List<Order> getOrdersByUserId(int userId);

	Order getOrderById(int orderId);

	boolean updateOrderStatus(int orderId, String orderStatus);

	List<Order> getAllOrders();
}