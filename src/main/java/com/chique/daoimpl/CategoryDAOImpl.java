package com.chique.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chique.dao.CategoryDAO;
import com.chique.model.Category;
import com.chique.util.DBConnection;

public class CategoryDAOImpl
        implements CategoryDAO {

    // Add Category
    @Override
    public boolean addCategory(Category category) {

        boolean isAdded = false;

        String query =
                "INSERT INTO categories "
                + "(category_name, description) "
                + "VALUES (?, ?)";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(
                    1,
                    category.getCategoryName());

            preparedStatement.setString(
                    2,
                    category.getDescription());

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {

                isAdded = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return isAdded;
    }

    // Get All Categories
    @Override
    public List<Category> getAllCategories() {

        List<Category> categoryList =
                new ArrayList<>();

        String query =
                "SELECT * FROM categories";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            while (resultSet.next()) {

                Category category =
                        new Category();

                category.setCategoryId(
                        resultSet.getInt("category_id"));

                category.setCategoryName(
                        resultSet.getString("category_name"));

                category.setDescription(
                        resultSet.getString("description"));

                category.setCreatedAt(
                        resultSet.getTimestamp("created_at"));

                categoryList.add(category);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return categoryList;
    }

    // Get Category By ID
    @Override
    public Category getCategoryById(
            int categoryId) {

        Category category = null;

        String query =
                "SELECT * FROM categories "
                + "WHERE category_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    categoryId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                category = new Category();

                category.setCategoryId(
                        resultSet.getInt("category_id"));

                category.setCategoryName(
                        resultSet.getString("category_name"));

                category.setDescription(
                        resultSet.getString("description"));

                category.setCreatedAt(
                        resultSet.getTimestamp("created_at"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return category;
    }

    // Update Category
    @Override
    public boolean updateCategory(
            Category category) {

        boolean isUpdated = false;

        String query =
                "UPDATE categories "
                + "SET category_name = ?, "
                + "description = ? "
                + "WHERE category_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(
                    1,
                    category.getCategoryName());

            preparedStatement.setString(
                    2,
                    category.getDescription());

            preparedStatement.setInt(
                    3,
                    category.getCategoryId());

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {

                isUpdated = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return isUpdated;
    }

    // Delete Category
    @Override
    public boolean deleteCategory(
            int categoryId) {

        boolean isDeleted = false;

        String query =
                "DELETE FROM categories "
                + "WHERE category_id = ?";

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(
                    1,
                    categoryId);

            int rows =
                    preparedStatement.executeUpdate();

            if (rows > 0) {

                isDeleted = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return isDeleted;
    }
}