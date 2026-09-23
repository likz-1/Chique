package com.chique.dao;

import java.util.List;

import com.chique.model.OrderItem;

public interface OrderItemDAO {

    boolean addOrderItem(
            OrderItem orderItem);

    List<OrderItem> getOrderItemsByOrderId(
            int orderId);
}