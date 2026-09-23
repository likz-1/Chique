package com.chique.dao;

import com.chique.model.User;

public interface UserDAO {

    // Register User
    boolean registerUser(User user);

    // Login User
    User loginUser(String email,
                   String password);

    // Get User By ID
    User getUserById(int userId);

    // Update User
    boolean updateUser(User user);

    // Delete User
    boolean deleteUser(int userId);

    // Check Email Exists
    boolean isEmailExists(String email);

    // Check Phone Exists
    boolean isPhoneExists(String phone);
}
