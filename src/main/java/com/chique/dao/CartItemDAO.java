package com.chique.dao;

import java.util.List;

import com.chique.model.CartItem;

public interface CartItemDAO {

    // Add Item To Cart
    boolean addCartItem(CartItem cartItem);

    // Get All Cart Items By Cart ID
    List<CartItem> getCartItemsByCartId(int cartId);

    // Update Quantity
    boolean updateQuantity(int cartItemId, int quantity);

    // Remove Cart Item
    boolean removeCartItem(int cartItemId);

    // Get Single Cart Item
    CartItem getCartItem(int cartId, int variantId);
}
