package com.chique.controller;

import java.io.IOException;
import java.math.BigDecimal;

import com.chique.dao.ProductDAO;
import com.chique.dao.ProductVariantDAO;
import com.chique.daoimpl.ProductDAOImpl;
import com.chique.daoimpl.ProductVariantDAOImpl;
import com.chique.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update-product")

public class UpdateProductServlet
        extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        try {

            int productId =
                    Integer.parseInt(
                            request.getParameter(
                                    "productId"));

            String productName =
                    request.getParameter(
                            "productName");

            String brand =
                    request.getParameter(
                            "brand");

            String description =
                    request.getParameter(
                            "description");

            BigDecimal price =
                    BigDecimal.valueOf(
                            Double.parseDouble(
                                    request.getParameter(
                                            "price")));

            String imageUrl =
                    request.getParameter(
                            "imageUrl");

            Product product =
                    new Product();

            product.setProductId(
                    productId);

            product.setProductName(
                    productName);

            product.setBrand(
                    brand);

            product.setDescription(
                    description);

            product.setPrice(
                    price);

            product.setImageUrl(
                    imageUrl);

            ProductDAO productDAO =
                    new ProductDAOImpl();

            boolean productUpdated =
                    productDAO.updateProduct(
                            product);

            // UPDATE STOCK

            String[] variantIds =
                    request.getParameterValues(
                            "variantId");

            String[] stockQuantities =
                    request.getParameterValues(
                            "stockQuantity");

            ProductVariantDAO variantDAO =
                    new ProductVariantDAOImpl();

            boolean stockUpdated = true;

            for(int i = 0;
                i < variantIds.length;
                i++) {

                int variantId =
                        Integer.parseInt(
                                variantIds[i]);

                int stock =
                        Integer.parseInt(
                                stockQuantities[i]);

                boolean updated =
                        variantDAO.updateStock(
                                variantId,
                                stock);

                if(!updated){

                    stockUpdated = false;
                }
            }

            if(productUpdated
                    && stockUpdated){

                response.sendRedirect(
                        "manage-products.jsp");
            }

            else{

                response.getWriter().println(
                        "Failed to Update Product");
            }

        } catch(Exception e){

            e.printStackTrace();

            response.getWriter().println(
                    "Something went wrong");
        }
    }
}