package com.softwarica.futsalmanagamentsystem.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    final public  String username;
    final public int id;
    final public String name;
    final public String address;
    final  public String phoneNumber;
    final public boolean isAdmin;

    public User( int id,String username, String name, String address, String phoneNumber) {
        this.username = username;
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isAdmin = false;
    }

    public User(ResultSet result) throws SQLException {
        this.username = result.getString("username");
        this.id = result.getInt("id");
        this.name = result.getString("name");
        this.address =result.getString("address");
        this.phoneNumber = result.getString("phoneNumber");
        this.isAdmin=result.getInt("is_admin")==1;
    }
}
