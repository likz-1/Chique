package com.chique.dao;

import java.util.List;

import com.chique.model.Category;

public interface CategoryDAO {

    // Add Category
    boolean addCategory(Category category);

    // Get All Categories
    List<Category> getAllCategories();

    // Get Category By ID
    Category getCategoryById(int categoryId);

    // Update Category
    boolean updateCategory(Category category);

    // Delete Category
    boolean deleteCategory(int categoryId);
}
