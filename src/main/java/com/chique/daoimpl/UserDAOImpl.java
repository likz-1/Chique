package com.chique.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chique.dao.UserDAO;
import com.chique.model.User;
import com.chique.util.DBConnection;

public class UserDAOImpl
        implements UserDAO {

    // REGISTER USER

    @Override
    public boolean registerUser(User user) {

        boolean isRegistered = false;

        String query =
                "INSERT INTO users "
                + "(full_name, email, phone, password, "
                + "address_line1, address_line2, city, "
                + "state, pincode, country) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

        ) {

            preparedStatement.setString(
                    1,
                    user.getFullName());

            preparedStatement.setString(
                    2,
                    user.getEmail());

            preparedStatement.setString(
                    3,
                    user.getPhone());

            preparedStatement.setString(
                    4,
                    user.getPassword());

            preparedStatement.setString(
                    5,
                    user.getAddressLine1());

            preparedStatement.setString(
                    6,
                    user.getAddressLine2());

            preparedStatement.setString(
                    7,
                    user.getCity());

            preparedStatement.setString(
                    8,
                    user.getState());

            preparedStatement.setString(
                    9,
                    user.getPincode());

            preparedStatement.setString(
                    10,
                    user.getCountry());

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                isRegistered = true;
            }

        } catch (Exception e) {

            System.out.println(
                    "REGISTER ERROR:");

            e.printStackTrace();
        }

        return isRegistered;
    }

    // LOGIN USER

    @Override
    public User loginUser(
            String email,
            String password) {

        User user = null;

        String query =
                "SELECT * FROM users "
                + "WHERE email = ? "
                + "AND password = ?";

        try (

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

        ) {

            preparedStatement.setString(
                    1,
                    email);

            preparedStatement.setString(
                    2,
                    password);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if(resultSet.next()) {

                user = new User();

                user.setUserId(
                        resultSet.getInt(
                                "user_id"));

                user.setFullName(
                        resultSet.getString(
                                "full_name"));

                user.setEmail(
                        resultSet.getString(
                                "email"));

                user.setPhone(
                        resultSet.getString(
                                "phone"));

                user.setPassword(
                        resultSet.getString(
                                "password"));

                user.setAddressLine1(
                        resultSet.getString(
                                "address_line1"));

                user.setAddressLine2(
                        resultSet.getString(
                                "address_line2"));

                user.setCity(
                        resultSet.getString(
                                "city"));

                user.setState(
                        resultSet.getString(
                                "state"));

                user.setPincode(
                        resultSet.getString(
                                "pincode"));

                user.setCountry(
                        resultSet.getString(
                                "country"));

                user.setCreatedAt(
                        resultSet.getTimestamp(
                                "created_at"));
            }

        } catch (Exception e) {

            System.out.println(
                    "LOGIN ERROR:");

            e.printStackTrace();
        }

        return user;
    }

    // GET USER BY ID

    @Override
    public User getUserById(
            int userId) {

        User user = null;

        String query =
                "SELECT * FROM users "
                + "WHERE user_id = ?";

        try (

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

        ) {

            preparedStatement.setInt(
                    1,
                    userId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if(resultSet.next()) {

                user = new User();

                user.setUserId(
                        resultSet.getInt(
                                "user_id"));

                user.setFullName(
                        resultSet.getString(
                                "full_name"));

                user.setEmail(
                        resultSet.getString(
                                "email"));

                user.setPhone(
                        resultSet.getString(
                                "phone"));

                user.setPassword(
                        resultSet.getString(
                                "password"));

                user.setAddressLine1(
                        resultSet.getString(
                                "address_line1"));

                user.setAddressLine2(
                        resultSet.getString(
                                "address_line2"));

                user.setCity(
                        resultSet.getString(
                                "city"));

                user.setState(
                        resultSet.getString(
                                "state"));

                user.setPincode(
                        resultSet.getString(
                                "pincode"));

                user.setCountry(
                        resultSet.getString(
                                "country"));

                user.setCreatedAt(
                        resultSet.getTimestamp(
                                "created_at"));
            }

        } catch (Exception e) {

            System.out.println(
                    "GET USER ERROR:");

            e.printStackTrace();
        }

        return user;
    }

    // UPDATE USER

    @Override
    public boolean updateUser(
            User user) {

        boolean isUpdated = false;

        String query =
                "UPDATE users "
                + "SET full_name = ?, "
                + "phone = ?, "
                + "address_line1 = ?, "
                + "address_line2 = ?, "
                + "city = ?, "
                + "state = ?, "
                + "pincode = ?, "
                + "country = ? "
                + "WHERE user_id = ?";

        try (

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

        ) {

            preparedStatement.setString(
                    1,
                    user.getFullName());

            preparedStatement.setString(
                    2,
                    user.getPhone());

            preparedStatement.setString(
                    3,
                    user.getAddressLine1());

            preparedStatement.setString(
                    4,
                    user.getAddressLine2());

            preparedStatement.setString(
                    5,
                    user.getCity());

            preparedStatement.setString(
                    6,
                    user.getState());

            preparedStatement.setString(
                    7,
                    user.getPincode());

            preparedStatement.setString(
                    8,
                    user.getCountry());

            preparedStatement.setInt(
                    9,
                    user.getUserId());

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                isUpdated = true;
            }

        } catch (Exception e) {

            System.out.println(
                    "UPDATE USER ERROR:");

            e.printStackTrace();
        }

        return isUpdated;
    }

    // DELETE USER

    @Override
    public boolean deleteUser(
            int userId) {

        boolean isDeleted = false;

        String query =
                "DELETE FROM users "
                + "WHERE user_id = ?";

        try (

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

        ) {

            preparedStatement.setInt(
                    1,
                    userId);

            int rows =
                    preparedStatement.executeUpdate();

            if(rows > 0) {

                isDeleted = true;
            }

        } catch (Exception e) {

            System.out.println(
                    "DELETE USER ERROR:");

            e.printStackTrace();
        }

        return isDeleted;
    }

    // CHECK EMAIL EXISTS

    @Override
    public boolean isEmailExists(
            String email) {

        boolean exists = false;

        String query =
                "SELECT email FROM users "
                + "WHERE email = ?";

        try (

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

        ) {

            preparedStatement.setString(
                    1,
                    email);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            exists = resultSet.next();

        } catch (Exception e) {

            System.out.println(
                    "EMAIL CHECK ERROR:");

            e.printStackTrace();
        }

        return exists;
    }

    // CHECK PHONE EXISTS

    @Override
    public boolean isPhoneExists(
            String phone) {

        boolean exists = false;

        String query =
                "SELECT phone FROM users "
                + "WHERE phone = ?";

        try (

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

        ) {

            preparedStatement.setString(
                    1,
                    phone);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            exists = resultSet.next();

        } catch (Exception e) {

            System.out.println(
                    "PHONE CHECK ERROR:");

            e.printStackTrace();
        }

        return exists;
    }
}