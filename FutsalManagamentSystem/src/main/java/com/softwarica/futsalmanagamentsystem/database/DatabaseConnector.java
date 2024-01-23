package com.softwarica.futsalmanagamentsystem.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    public static Connection getDatabaseConnection() throws Exception {
        Connection connection = null;
        try {
            var username = "root";
            var password = "root";
            var dbName = "futsalmanagement";
            var serverAddressUrl = "localhost";
            var serverAddress = serverAddressUrl + ":3306/" + dbName;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + serverAddress,
                    username, password);
            connection.setAutoCommit(true);
            return connection;
        } catch (Exception e) {
            throw e;
        }
    }
}
