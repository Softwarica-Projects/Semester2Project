package com.softwarica.futsalmanagamentsystem.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Favourite {
    final public int id;
    final public int futsalId;

    public Favourite(int id, int futsalId) {
        this.id = id;
        this.futsalId = futsalId;
    }

    public Favourite(ResultSet result) throws SQLException {
        this.id = result.getInt("id");
        this.futsalId = result.getInt("futsal_id");
    }

}
