package com.chique.model;

public class CartItem {

    private int cartItemId;

    private int cartId;

    private int variantId;

    private int quantity;

    private String productName;

    private double price;

    private String imageUrl;

    private String size;

    // DEFAULT CONSTRUCTOR

    public CartItem() {

    }

    // PARAMETERIZED CONSTRUCTOR

    public CartItem(
            int cartItemId,
            int cartId,
            int variantId,
            int quantity) {

        this.cartItemId = cartItemId;

        this.cartId = cartId;

        this.variantId = variantId;

        this.quantity = quantity;
    }

    // GETTERS AND SETTERS

    public int getCartItemId() {

        return cartItemId;
    }

    public void setCartItemId(
            int cartItemId) {

        this.cartItemId = cartItemId;
    }

    public int getCartId() {

        return cartId;
    }

    public void setCartId(
            int cartId) {

        this.cartId = cartId;
    }

    public int getVariantId() {

        return variantId;
    }

    public void setVariantId(
            int variantId) {

        this.variantId = variantId;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(
            int quantity) {

        this.quantity = quantity;
    }

    public String getProductName() {

        return productName;
    }

    public void setProductName(
            String productName) {

        this.productName = productName;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(
            double price) {

        this.price = price;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(
            String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getSize() {

        return size;
    }

    public void setSize(
            String size) {

        this.size = size;
    }
}