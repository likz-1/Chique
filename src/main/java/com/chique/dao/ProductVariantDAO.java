package com.chique.dao;

import java.util.List;

import com.chique.model.ProductVariant;

public interface ProductVariantDAO {

    boolean addVariant(
            ProductVariant variant);

    List<ProductVariant> getVariantsByProductId(
            int productId);

    int getVariantIdByProductAndSize(
            String productName,
            String size);

    boolean reduceStock(
            int variantId,
            int quantity);

    boolean updateStock(
            int variantId,
            int stockQuantity);
    
    boolean increaseStock(
            int variantId,
            int quantity);

}