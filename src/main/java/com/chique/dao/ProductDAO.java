package com.chique.dao;

import java.math.BigDecimal;
import java.util.List;

import com.chique.model.Product;

public interface ProductDAO {

    // Add Product
    boolean addProduct(Product product);

    // Get All Products
    List<Product> getAllProducts();

    // Get Product By ID
    Product getProductById(int productId);

    // Update Product
    boolean updateProduct(Product product);

    // Delete Product
    boolean deleteProduct(int productId);

    // Get Products By Category
    List<Product> getProductsByCategory(int categoryId);

    // Search Products
    List<Product> searchProducts(String keyword);

    // Latest Products
    List<Product> getLatestProducts();

    // Related Products
    List<Product> getRelatedProducts(
            int categoryId,
            int productId);

    // Filter By Price
    List<Product> filterProductsByPrice(
            BigDecimal minPrice,
            BigDecimal maxPrice);

    // Filter By Size
    List<Product> filterProductsBySize(
            String size);
    
    
}
