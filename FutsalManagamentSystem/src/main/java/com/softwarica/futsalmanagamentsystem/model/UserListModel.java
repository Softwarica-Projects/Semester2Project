package com.softwarica.futsalmanagamentsystem.Model;


import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rishan
 */
public class UserListModel {
    final public int id;
    final public String name;

    public UserListModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserListModel(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.name = result.getString("name");
    } 

}
