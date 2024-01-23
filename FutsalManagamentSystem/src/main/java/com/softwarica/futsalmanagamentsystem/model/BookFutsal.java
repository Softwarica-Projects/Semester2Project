package com.softwarica.futsalmanagamentsystem.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookFutsal {

    final public int futsalId;
    final public String bookingDateTime;
    final public int bookingHour;
    final public int userId;

    public BookFutsal(int futsalId, String bookingDateTime, int bookingHour, int userId) {
        this.futsalId = futsalId;
        this.bookingDateTime = bookingDateTime;
        this.bookingHour = bookingHour;
        this.userId = userId; 
    }

}
