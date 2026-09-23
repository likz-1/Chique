package com.chique.util;

import java.sql.Connection;

public class TestConnection {

    public static void main(String[] args) {

        Connection connection =
                DBConnection.getConnection();

        if(connection != null) {

            System.out.println(
                    "DATABASE CONNECTED");
        }

        else {

            System.out.println(
                    "DATABASE NOT CONNECTED");
        }
    }
}