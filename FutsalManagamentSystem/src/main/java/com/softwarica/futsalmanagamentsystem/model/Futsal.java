package com.softwarica.futsalmanagamentsystem.Model;

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
    final public boolean isFavourite;

    final public String createdBy;
    final String modifiedDate;
    final String modifiedBy;
    final  public String courtTypeName;

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
        isFavourite = false;
        this.courtTypeName="";
    }

    public Futsal(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.name = result.getString("name");
        this.location = result.getString("location");
        this.courtTypeId = result.getInt("court_type_id");
        this.price = result.getDouble("price");
        this.openingHour = result.getInt("opening_hour");
        this.closingHour = result.getInt("closing_hour");
        this.newFutsalRequestId = result.getInt("new_futsal_request_id");
        this.createdDate = result.getString("created_date");
        this.createdBy = result.getString("created_by");
        this.modifiedDate = result.getString("modified_date");
        this.modifiedBy = result.getString("modified_by");
        this.isFavourite = result.getInt("is_favourite") == 1;
        this.courtTypeName=result.getString("court_type_name");

    }
}
