package com.chique.daoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chique.dao.ProductDAO;
import com.chique.model.Product;
import com.chique.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public boolean addProduct(Product product) {

        boolean isAdded = false;

        String query =
                "INSERT INTO products "
                + "(category_id, product_name, brand, "
                + "description, price, image_url, is_active) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    product.getCategoryId());

            preparedStatement.setString(
                    2,
                    product.getProductName());

            preparedStatement.setString(
                    3,
                    product.getBrand());

            preparedStatement.setString(
                    4,
                    product.getDescription());

            preparedStatement.setBigDecimal(
                    5,
                    product.getPrice());

            preparedStatement.setString(
                    6,
                    product.getImageUrl());

            preparedStatement.setBoolean(
                    7,
                    product.isActive());

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                isAdded = true;
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return isAdded;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> productList =
                new ArrayList<>();

        String query =
                "SELECT * FROM products";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            while(resultSet.next()) {

                Product product =
                        new Product();

                product.setProductId(
                        resultSet.getInt("product_id"));

                product.setCategoryId(
                        resultSet.getInt("category_id"));

                product.setProductName(
                        resultSet.getString("product_name"));

                product.setBrand(
                        resultSet.getString("brand"));

                product.setDescription(
                        resultSet.getString("description"));

                product.setPrice(
                        resultSet.getBigDecimal("price"));

                product.setImageUrl(
                        resultSet.getString("image_url"));

                product.setActive(
                        resultSet.getBoolean("is_active"));

                productList.add(product);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public Product getProductById(int productId) {

        Product product = null;

        String query =
                "SELECT * FROM products "
                + "WHERE product_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    productId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if(resultSet.next()) {

                product = new Product();

                product.setProductId(
                        resultSet.getInt("product_id"));

                product.setCategoryId(
                        resultSet.getInt("category_id"));

                product.setProductName(
                        resultSet.getString("product_name"));

                product.setBrand(
                        resultSet.getString("brand"));

                product.setDescription(
                        resultSet.getString("description"));

                product.setPrice(
                        resultSet.getBigDecimal("price"));

                product.setImageUrl(
                        resultSet.getString("image_url"));

                product.setActive(
                        resultSet.getBoolean("is_active"));
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return product;
    }

    @Override
    public boolean updateProduct(Product product) {

        boolean isUpdated = false;

        String query =
                "UPDATE products "
                + "SET product_name = ?, "
                + "brand = ?, "
                + "description = ?, "
                + "price = ?, "
                + "image_url = ? "
                + "WHERE product_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            query);

            preparedStatement.setString(
                    1,
                    product.getProductName());

            preparedStatement.setString(
                    2,
                    product.getBrand());

            preparedStatement.setString(
                    3,
                    product.getDescription());

            preparedStatement.setBigDecimal(
                    4,
                    product.getPrice());

            preparedStatement.setString(
                    5,
                    product.getImageUrl());

            preparedStatement.setInt(
                    6,
                    product.getProductId());

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
    public boolean deleteProduct(int productId) {

        boolean isDeleted = false;

        String deleteVariants =
                "DELETE FROM product_variants "
                + "WHERE product_id = ?";

        String deleteProduct =
                "DELETE FROM products "
                + "WHERE product_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement variantStatement =
                    connection.prepareStatement(
                            deleteVariants);

            variantStatement.setInt(
                    1,
                    productId);

            variantStatement.executeUpdate();

            PreparedStatement productStatement =
                    connection.prepareStatement(
                            deleteProduct);

            productStatement.setInt(
                    1,
                    productId);

            int rows =
                    productStatement.executeUpdate();

            if(rows > 0){

                isDeleted = true;
            }

        } catch(Exception e){

            e.printStackTrace();
        }

        return isDeleted;
    }

    @Override
    public List<Product> getProductsByCategory(
            int categoryId) {

        List<Product> productList =
                new ArrayList<>();

        String query =
                "SELECT * FROM products "
                + "WHERE category_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    categoryId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            while(resultSet.next()) {

                Product product =
                        new Product();

                product.setProductId(
                        resultSet.getInt("product_id"));

                product.setCategoryId(
                        resultSet.getInt("category_id"));

                product.setProductName(
                        resultSet.getString("product_name"));

                product.setBrand(
                        resultSet.getString("brand"));

                product.setDescription(
                        resultSet.getString("description"));

                product.setPrice(
                        resultSet.getBigDecimal("price"));

                product.setImageUrl(
                        resultSet.getString("image_url"));

                product.setActive(
                        resultSet.getBoolean("is_active"));

                productList.add(product);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> searchProducts(
            String keyword) {

        List<Product> productList =
                new ArrayList<>();

        String query =
                "SELECT * FROM products "
                + "WHERE product_name LIKE ? "
                + "OR brand LIKE ? "
                + "OR description LIKE ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            String searchKeyword =
                    "%" + keyword + "%";

            preparedStatement.setString(
                    1,
                    searchKeyword);

            preparedStatement.setString(
                    2,
                    searchKeyword);

            preparedStatement.setString(
                    3,
                    searchKeyword);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            while(resultSet.next()) {

                Product product =
                        new Product();

                product.setProductId(
                        resultSet.getInt("product_id"));

                product.setCategoryId(
                        resultSet.getInt("category_id"));

                product.setProductName(
                        resultSet.getString("product_name"));

                product.setBrand(
                        resultSet.getString("brand"));

                product.setDescription(
                        resultSet.getString("description"));

                product.setPrice(
                        resultSet.getBigDecimal("price"));

                product.setImageUrl(
                        resultSet.getString("image_url"));

                product.setActive(
                        resultSet.getBoolean("is_active"));

                productList.add(product);
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> getLatestProducts() {

        return new ArrayList<>();
    }

    @Override
    public List<Product> getRelatedProducts(
            int categoryId,
            int productId) {

        return new ArrayList<>();
    }

    @Override
    public List<Product> filterProductsByPrice(
            BigDecimal minPrice,
            BigDecimal maxPrice) {

        return new ArrayList<>();
    }

    @Override
    public List<Product> filterProductsBySize(
            String size) {

        return new ArrayList<>();
    }
 
}