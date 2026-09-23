package com.chique.dao;

import com.chique.model.Cart;

public interface CartDAO {

    // Create Cart
    boolean createCart(int userId);

    // Get Cart By User ID
    Cart getCartByUserId(int userId);

    // Get Cart By ID
    Cart getCartById(int cartId);

    // Delete Cart
    boolean deleteCart(int cartId);

    // Clear Cart
    boolean clearCart(int cartId);
    
    
}
