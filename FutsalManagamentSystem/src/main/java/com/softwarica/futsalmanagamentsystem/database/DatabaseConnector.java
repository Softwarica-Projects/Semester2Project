package com.softwarica.futsalmanagamentsystem.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    public static Connection getDatabaseConnection() throws Exception {
        Connection connection = null;
        try {
            var username =
//                    "futsal_root";
              "root";
            var password=
//                    "Futsal@123#";
             "root";
            var dbName =
//                    "futsalmgmt";
             "futsalmanagement";
            var serverAddressUrl = "localhost";
//            "db4free.net";
            var serverAddress=serverAddressUrl+":3306/"+dbName;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://"+serverAddress,
                    username, password);
            connection.setAutoCommit(true);
            return connection;
        } catch (Exception e) {
            throw e;
        }
    }
}
