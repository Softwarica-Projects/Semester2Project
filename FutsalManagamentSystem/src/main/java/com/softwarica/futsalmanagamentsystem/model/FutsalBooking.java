package com.softwarica.futsalmanagamentsystem.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FutsalBooking {

    final public int id;
    final public int userId;
    final public int futsalId;
    final public String bookingDateTime;
    final public int bookingHour;
    final public boolean isApproved;
    final public double totalPrice;
    final public String createdDate;
    final public String createdBy;
    final public String modifiedDate;
    final public String modifiedBy;

    public FutsalBooking(int id, int userId, int futsalId, String bookingDateTime, int bookingHour, boolean isApproved,
            double totalPrice, String createdDate, String createdBy, String modifiedDate, String modifiedBy) {
        this.id = id;
        this.userId = userId;
        this.futsalId = futsalId;
        this.bookingDateTime = bookingDateTime;
        this.bookingHour = bookingHour;
        this.isApproved = isApproved;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public FutsalBooking(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.userId = result.getInt("user_id");
        this.futsalId = result.getInt("futsal_id");
        this.bookingDateTime = result.getString("booking_date_time");
        this.bookingHour = result.getInt("booking_hour");
        this.isApproved = result.getInt("is_approved") == 1;
        this.totalPrice = result.getDouble("total_price");
        this.createdDate = result.getString("created_date");
        this.createdBy = result.getString("created_by");
        this.modifiedDate = result.getString("modified_date");
        this.modifiedBy = result.getString("modified_by");

    }
}
