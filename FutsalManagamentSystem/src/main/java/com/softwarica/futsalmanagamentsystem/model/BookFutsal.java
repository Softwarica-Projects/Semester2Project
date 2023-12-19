package com.softwarica.futsalmanagamentsystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookFutsal {
    final public int futsalId;

    final public String bookingDateTime;

    final public int bookingHour;

    public BookFutsal(int futsalId, String bookingDateTime, int bookingHour) {
        this.futsalId = futsalId;
        this.bookingDateTime = bookingDateTime;
        this.bookingHour = bookingHour;
    }

}
