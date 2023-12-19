package com.softwarica.futsalmanagamentsystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Futsal {
    final public int id;

    final public String name;
    final public String location;
    final public int courtTypeId;
    final public double price;
    final public int openingHour;

    final public int closingHour;
    final public int newFutsalRequestId;
    final public String createdDate;

    final public String createdBy;
    final String modifiedDate;
    final String modifiedBy;

    public Futsal(int id, String name, String location, int courtTypeId, double price, int openingHour, int closingHour,
            int newFutsalRequestId, String createdDate, String createdBy, String modifiedDate, String modifiedBy) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.courtTypeId = courtTypeId;
        this.price = price;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.newFutsalRequestId = newFutsalRequestId;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public Futsal(ResultSet result) throws SQLException {
        this.id = 0;
        this.name = "";
        this.location = "";
        this.courtTypeId = 0;
        this.price = 0;
        this.openingHour = 0;
        this.closingHour = 0;
        this.newFutsalRequestId = 0;
        this.createdDate = "";
        this.createdBy = "";
        this.modifiedDate = "";
        this.modifiedBy = "";

    }
}
