package com.chique.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chique.dao.CartItemDAO;
import com.chique.model.CartItem;
import com.chique.util.DBConnection;

public class CartItemDAOImpl implements CartItemDAO {

    // Add Cart Item
    @Override
    public boolean addCartItem(CartItem cartItem) {

        boolean isAdded = false;

        String query =
                "INSERT INTO cart_items(cart_id, variant_id, quantity) "
              + "VALUES(?, ?, ?)";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    cartItem.getCartId());

            preparedStatement.setInt(
                    2,
                    cartItem.getVariantId());

            preparedStatement.setInt(
                    3,
                    cartItem.getQuantity());

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

    // Get Cart Items By Cart ID
    @Override
    public List<CartItem> getCartItemsByCartId(int cartId) {

        List<CartItem> cartItemList =
                new ArrayList<>();

        String query =
                "SELECT * FROM cart_items "
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

            while (resultSet.next()) {

                CartItem cartItem =
                        new CartItem();

                cartItem.setCartItemId(
                        resultSet.getInt("cart_item_id"));

                cartItem.setCartId(
                        resultSet.getInt("cart_id"));

                cartItem.setVariantId(
                        resultSet.getInt("variant_id"));

                cartItem.setQuantity(
                        resultSet.getInt("quantity"));

                cartItemList.add(cartItem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartItemList;
    }

    // Update Quantity
    @Override
    public boolean updateQuantity(
            int cartItemId,
            int quantity) {

        boolean isUpdated = false;

        String query =
                "UPDATE cart_items "
              + "SET quantity = ? "
              + "WHERE cart_item_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    quantity);

            preparedStatement.setInt(
                    2,
                    cartItemId);

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {
                isUpdated = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    // Remove Cart Item
    @Override
    public boolean removeCartItem(int cartItemId) {

        boolean isDeleted = false;

        String query =
                "DELETE FROM cart_items "
              + "WHERE cart_item_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    cartItemId);

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

    // Get Single Cart Item
    @Override
    public CartItem getCartItem(
            int cartId,
            int variantId) {

        CartItem cartItem = null;

        String query =
                "SELECT * FROM cart_items "
              + "WHERE cart_id = ? "
              + "AND variant_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    cartId);

            preparedStatement.setInt(
                    2,
                    variantId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                cartItem = new CartItem();

                cartItem.setCartItemId(
                        resultSet.getInt("cart_item_id"));

                cartItem.setCartId(
                        resultSet.getInt("cart_id"));

                cartItem.setVariantId(
                        resultSet.getInt("variant_id"));

                cartItem.setQuantity(
                        resultSet.getInt("quantity"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartItem;
    }
}