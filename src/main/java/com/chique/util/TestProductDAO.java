package com.chique.util;

import java.util.List;

import com.chique.dao.ProductDAO;
import com.chique.daoimpl.ProductDAOImpl;
import com.chique.model.Product;

public class TestProductDAO {

    public static void main(String[] args) {

        ProductDAO productDAO =
                new ProductDAOImpl();

        List<Product> productList =
                productDAO.getAllProducts();

        System.out.println(
                "TOTAL PRODUCTS : "
                + productList.size());

        for(Product product : productList) {

            System.out.println("-------------------------");

            System.out.println(
                    "ID : "
                    + product.getProductId());

            System.out.println(
                    "NAME : "
                    + product.getProductName());

            System.out.println(
                    "BRAND : "
                    + product.getBrand());

            System.out.println(
                    "PRICE : "
                    + product.getPrice());

            System.out.println(
                    "DESCRIPTION : "
                    + product.getDescription());

            System.out.println(
                    "IMAGE : "
                    + product.getImageUrl());

            System.out.println(
                    "ACTIVE : "
                    + product.isActive());
        }
    }
}