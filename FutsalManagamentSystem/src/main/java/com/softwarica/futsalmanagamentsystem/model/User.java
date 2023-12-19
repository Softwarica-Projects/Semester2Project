package com.softwarica.futsalmanagamentsystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    final String username;
    final int id;
    final String name;
    final String address;
    final String phoneNumber;

    public User(String username, int id, String name, String address, String phoneNumber) {
        this.username = username;
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User(ResultSet result) throws SQLException {
        this.username = "";
        this.id = 0;
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
    }
}
