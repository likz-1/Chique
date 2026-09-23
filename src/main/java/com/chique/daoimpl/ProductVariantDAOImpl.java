package com.chique.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chique.dao.ProductVariantDAO;
import com.chique.model.ProductVariant;
import com.chique.util.DBConnection;

public class ProductVariantDAOImpl
        implements ProductVariantDAO {

    @Override
    public boolean addVariant(
            ProductVariant variant) {

        boolean isAdded = false;

        String query =
                "INSERT INTO product_variants "
                + "(product_id, size, stock_quantity) "
                + "VALUES (?, ?, ?)";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            query);

            preparedStatement.setInt(
                    1,
                    variant.getProductId());

            preparedStatement.setString(
                    2,
                    variant.getSize());

            preparedStatement.setInt(
                    3,
                    variant.getStockQuantity());

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0){

                isAdded = true;
            }

        } catch(Exception e){

            e.printStackTrace();
        }

        return isAdded;
    }

    @Override
    public List<ProductVariant> getVariantsByProductId(
            int productId) {

        List<ProductVariant> variants =
                new ArrayList<>();

        String query =
                "SELECT * FROM product_variants "
                + "WHERE product_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            query);

            preparedStatement.setInt(
                    1,
                    productId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            while(resultSet.next()){

                ProductVariant variant =
                        new ProductVariant();

                variant.setVariantId(
                        resultSet.getInt(
                                "variant_id"));

                variant.setProductId(
                        resultSet.getInt(
                                "product_id"));

                variant.setSize(
                        resultSet.getString(
                                "size"));

                variant.setStockQuantity(
                        resultSet.getInt(
                                "stock_quantity"));

                variants.add(variant);
            }

        } catch(Exception e){

            e.printStackTrace();
        }

        return variants;
    }

    @Override
    public int getVariantIdByProductAndSize(
            String productName,
            String size) {

        int variantId = 0;

        String query =
                "SELECT pv.variant_id "
                + "FROM product_variants pv "
                + "JOIN products p "
                + "ON pv.product_id = p.product_id "
                + "WHERE p.product_name = ? "
                + "AND pv.size = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            query);

            preparedStatement.setString(
                    1,
                    productName);

            preparedStatement.setString(
                    2,
                    size);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if(resultSet.next()) {

                variantId =
                        resultSet.getInt(
                                "variant_id");
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return variantId;
    }
    
    @Override
    public boolean reduceStock(
            int variantId,
            int quantity) {

        boolean isUpdated = false;

        String query =
                "UPDATE product_variants "
                + "SET stock_quantity = "
                + "stock_quantity - ? "
                + "WHERE variant_id = ? "
                + "AND stock_quantity >= ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            query);

            preparedStatement.setInt(
                    1,
                    quantity);

            preparedStatement.setInt(
                    2,
                    variantId);

            preparedStatement.setInt(
                    3,
                    quantity);

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0){

                isUpdated = true;
            }

        } catch(Exception e){

            e.printStackTrace();
        }

        return isUpdated;
    }
    
    @Override
    public boolean updateStock(
            int variantId,
            int stockQuantity) {

        boolean isUpdated = false;

        String query =
                "UPDATE product_variants "
                + "SET stock_quantity = ? "
                + "WHERE variant_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            query);

            preparedStatement.setInt(
                    1,
                    stockQuantity);

            preparedStatement.setInt(
                    2,
                    variantId);

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0){

                isUpdated = true;
            }

        } catch(Exception e){

            e.printStackTrace();
        }

        return isUpdated;
    }
    
    @Override
    public boolean increaseStock(
            int variantId,
            int quantity) {

        boolean isUpdated = false;

        String query =
                "UPDATE product_variants "
                + "SET stock_quantity = "
                + "stock_quantity + ? "
                + "WHERE variant_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            query);

            preparedStatement.setInt(
                    1,
                    quantity);

            preparedStatement.setInt(
                    2,
                    variantId);

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0){

                isUpdated = true;
            }

        } catch(Exception e){

            e.printStackTrace();
        }

        return isUpdated;
    }
}