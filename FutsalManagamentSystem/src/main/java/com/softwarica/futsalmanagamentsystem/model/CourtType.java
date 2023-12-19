package com.softwarica.futsalmanagamentsystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourtType {
    final public int id;
    final public String name;

    public CourtType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CourtType(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.name = result.getString("name");
    }

}
