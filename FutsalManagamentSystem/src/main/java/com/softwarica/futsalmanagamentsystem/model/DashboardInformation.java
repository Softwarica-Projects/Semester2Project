/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softwarica.futsalmanagamentsystem.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rishan
 */
public class DashboardInformation {

    public int futsalList;
    public int totalBooking;
    public int favourites;
    public int bookingRequest;
    public int courtType;
    public int futsalRequst;
    public int userList;

    public DashboardInformation(ResultSet result) throws SQLException {
        this.futsalList = result.getInt("futsalList");
        this.totalBooking = result.getInt("totalBooking");
        this.favourites = result.getInt("favourites");
        this.bookingRequest = result.getInt("bookingRequest");
        this.courtType = result.getInt("courtType");
        this.futsalRequst = result.getInt("futsalRequst"); 
        this.userList = result.getInt("userList"); 

    }
}
