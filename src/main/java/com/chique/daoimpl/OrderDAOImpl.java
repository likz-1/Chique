package com.chique.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chique.dao.OrderDAO;
import com.chique.model.Order;
import com.chique.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public boolean placeOrder(Order order) {

		boolean isPlaced = false;

		String query = "INSERT INTO orders " + "(user_id, total_amount, " + "payment_method, payment_status, "
				+ "order_status, shipping_address) " + "VALUES (?, ?, ?, ?, ?, ?)";

		try {

			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, order.getUserId());

			preparedStatement.setBigDecimal(2, order.getTotalAmount());

			preparedStatement.setString(3, order.getPaymentMethod());

			preparedStatement.setString(4, order.getPaymentStatus());

			preparedStatement.setString(5, order.getOrderStatus());

			preparedStatement.setString(6, order.getShippingAddress());

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				ResultSet resultSet = preparedStatement.getGeneratedKeys();

				if (resultSet.next()) {

					order.setOrderId(resultSet.getInt(1));
				}

				isPlaced = true;
			}

		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return isPlaced;
	}

	// Get Orders By User ID
	@Override
	public List<Order> getOrdersByUserId(int userId) {

		List<Order> orderList = new ArrayList<>();

		String query = "SELECT * FROM orders " + "WHERE user_id = ? " + "ORDER BY order_date DESC";

		try {

			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Order order = new Order();

				order.setOrderId(resultSet.getInt("order_id"));

				order.setUserId(resultSet.getInt("user_id"));

				order.setTotalAmount(resultSet.getBigDecimal("total_amount"));

				order.setPaymentMethod(resultSet.getString("payment_method"));

				order.setPaymentStatus(resultSet.getString("payment_status"));

				order.setOrderStatus(resultSet.getString("order_status"));

				order.setShippingAddress(resultSet.getString("shipping_address"));

				order.setOrderDate(resultSet.getTimestamp("order_date"));

				orderList.add(order);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return orderList;
	}

	// Get Order By ID
	@Override
	public Order getOrderById(int orderId) {

		Order order = null;

		String query = "SELECT * FROM orders " + "WHERE order_id = ?";

		try {

			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, orderId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				order = new Order();

				order.setOrderId(resultSet.getInt("order_id"));

				order.setUserId(resultSet.getInt("user_id"));

				order.setTotalAmount(resultSet.getBigDecimal("total_amount"));

				order.setPaymentMethod(resultSet.getString("payment_method"));

				order.setPaymentStatus(resultSet.getString("payment_status"));

				order.setOrderStatus(resultSet.getString("order_status"));

				order.setShippingAddress(resultSet.getString("shipping_address"));

				order.setOrderDate(resultSet.getTimestamp("order_date"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return order;
	}

	// Update Order Status
	@Override
	public boolean updateOrderStatus(int orderId, String orderStatus) {

		boolean isUpdated = false;

		String query = "UPDATE orders " + "SET order_status = ? " + "WHERE order_id = ?";

		try {

			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, orderStatus);

			preparedStatement.setInt(2, orderId);

			int rows = preparedStatement.executeUpdate();

			if (rows > 0) {

				isUpdated = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isUpdated;
	}

	@Override
	public List<Order> getAllOrders() {

		List<Order> orderList = new ArrayList<>();

		String query = "SELECT * FROM orders " + "ORDER BY order_date DESC";

		try {

			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Order order = new Order();

				order.setOrderId(resultSet.getInt("order_id"));

				order.setUserId(resultSet.getInt("user_id"));

				order.setTotalAmount(resultSet.getBigDecimal("total_amount"));

				order.setPaymentMethod(resultSet.getString("payment_method"));

				order.setPaymentStatus(resultSet.getString("payment_status"));

				order.setOrderStatus(resultSet.getString("order_status"));

				order.setShippingAddress(resultSet.getString("shipping_address"));

				order.setOrderDate(resultSet.getTimestamp("order_date"));

				orderList.add(order);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return orderList;
	}
}