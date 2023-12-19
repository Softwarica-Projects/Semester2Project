package com.softwarica.futsalmanagamentsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    public static Connection getDatabaseConnection() throws Exception {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/futsalmanagement",
                    "root", "root");
            connection.setAutoCommit(true);
            return connection;
        } catch (Exception e) {
            throw e;
        }
    }
}
