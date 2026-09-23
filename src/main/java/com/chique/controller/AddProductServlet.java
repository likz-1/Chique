package com.chique.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chique.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add-product")

public class AddProductServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        Boolean admin =
                (Boolean) session.getAttribute(
                        "admin");

        if(admin == null || !admin){

            response.sendRedirect(
                    "login.jsp");

            return;
        }

        String productName =
                request.getParameter(
                        "productName");

        String brand =
                request.getParameter(
                        "brand");

        String description =
                request.getParameter(
                        "description");

        String imageUrl =
                request.getParameter(
                        "imageUrl");

        BigDecimal price =
                BigDecimal.valueOf(
                        Double.parseDouble(
                                request.getParameter(
                                        "price")));

        int categoryId =
                Integer.parseInt(
                        request.getParameter(
                                "categoryId"));

        String size =
                request.getParameter(
                        "size");

        int stockQuantity =
                Integer.parseInt(
                        request.getParameter(
                                "stockQuantity"));

        try {

            Connection connection =
                    DBConnection.getConnection();

            String productQuery =
                    "INSERT INTO products "
                    + "(category_id, product_name, "
                    + "brand, description, "
                    + "price, image_url, is_active) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement productStatement =
                    connection.prepareStatement(
                            productQuery,
                            PreparedStatement.RETURN_GENERATED_KEYS);

            productStatement.setInt(
                    1,
                    categoryId);

            productStatement.setString(
                    2,
                    productName);

            productStatement.setString(
                    3,
                    brand);

            productStatement.setString(
                    4,
                    description);

            productStatement.setBigDecimal(
                    5,
                    price);

            productStatement.setString(
                    6,
                    imageUrl);

            productStatement.setBoolean(
                    7,
                    true);

            productStatement.executeUpdate();

            ResultSet generatedKeys =
                    productStatement.getGeneratedKeys();

            int productId = 0;

            if(generatedKeys.next()) {

                productId =
                        generatedKeys.getInt(1);
            }

            String variantQuery =
                    "INSERT INTO product_variants "
                    + "(product_id, size, stock_quantity) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement variantStatement =
                    connection.prepareStatement(
                            variantQuery);

            variantStatement.setInt(
                    1,
                    productId);

            variantStatement.setString(
                    2,
                    size);

            variantStatement.setInt(
                    3,
                    stockQuantity);

            variantStatement.executeUpdate();

            response.sendRedirect(
                    "manage-products.jsp");

        } catch(Exception e){

            e.printStackTrace();

            response.getWriter().println(
                    "Failed to Add Product");
        }
    }
}