package com.chique.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chique.dao.OrderItemDAO;
import com.chique.model.OrderItem;
import com.chique.util.DBConnection;

public class OrderItemDAOImpl
        implements OrderItemDAO {

    // Add Order Item
    @Override
    public boolean addOrderItem(
            OrderItem orderItem) {

        boolean isAdded = false;

        String query =
                "INSERT INTO order_items "
                + "(order_id, variant_id, quantity, price) "
                + "VALUES (?, ?, ?, ?)";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    orderItem.getOrderId());

            preparedStatement.setInt(
                    2,
                    orderItem.getVariantId());

            preparedStatement.setInt(
                    3,
                    orderItem.getQuantity());

            preparedStatement.setBigDecimal(
                    4,
                    orderItem.getPrice());

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {

                isAdded = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return isAdded;
    }

    // Get Order Items By Order ID
    @Override
    public List<OrderItem>
    getOrderItemsByOrderId(
            int orderId) {

        List<OrderItem> orderItemList =
                new ArrayList<>();

        String query =
                "SELECT * FROM order_items "
                + "WHERE order_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    orderId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            while (resultSet.next()) {

                OrderItem orderItem =
                        new OrderItem();

                orderItem.setOrderItemId(
                        resultSet.getInt("order_item_id"));

                orderItem.setOrderId(
                        resultSet.getInt("order_id"));

                orderItem.setVariantId(
                        resultSet.getInt("variant_id"));

                orderItem.setQuantity(
                        resultSet.getInt("quantity"));

                orderItem.setPrice(
                        resultSet.getBigDecimal("price"));

                orderItemList.add(orderItem);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return orderItemList;
    }
}