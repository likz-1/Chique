package com.chique.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chique.dao.CartDAO;
import com.chique.model.Cart;
import com.chique.util.DBConnection;

public class CartDAOImpl
        implements CartDAO {

    // Create Cart
    @Override
    public boolean createCart(
            int userId) {

        boolean isCreated = false;

        String query =
                "INSERT INTO cart(user_id) "
                + "VALUES(?)";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    userId);

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {

                isCreated = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return isCreated;
    }

    // Get Cart By User ID
    @Override
    public Cart getCartByUserId(
            int userId) {

        Cart cart = null;

        String query =
                "SELECT * FROM cart "
                + "WHERE user_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    userId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                cart = new Cart();

                cart.setCartId(
                        resultSet.getInt("cart_id"));

                cart.setUserId(
                        resultSet.getInt("user_id"));

                cart.setCreatedAt(
                        resultSet.getTimestamp("created_at"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return cart;
    }

    // Get Cart By ID
    @Override
    public Cart getCartById(
            int cartId) {

        Cart cart = null;

        String query =
                "SELECT * FROM cart "
                + "WHERE cart_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    cartId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                cart = new Cart();

                cart.setCartId(
                        resultSet.getInt("cart_id"));

                cart.setUserId(
                        resultSet.getInt("user_id"));

                cart.setCreatedAt(
                        resultSet.getTimestamp("created_at"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return cart;
    }

    // Delete Cart
    @Override
    public boolean deleteCart(
            int cartId) {

        boolean isDeleted = false;

        String query =
                "DELETE FROM cart "
                + "WHERE cart_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    cartId);

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {

                isDeleted = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return isDeleted;
    }
 // Clear Cart
    @Override
    public boolean clearCart(
            int cartId) {

        boolean isCleared = false;

        String query =
                "DELETE FROM cart_items "
                + "WHERE cart_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    cartId);

            int rows =
                    preparedStatement.executeUpdate();

            if (rows >= 0) {

                isCleared = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return isCleared;
    }
}
