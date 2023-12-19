package com.softwarica.futsalmanagamentsystem.service.CourtTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import com.softwarica.futsalmanagamentsystem.database.*;
import com.softwarica.futsalmanagamentsystem.model.CourtType;

public class CourtTypeSeviceImpl implements CourtTypeSevice {

    public List<CourtType> getList() throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {

            var statement = dataConnection.createStatement();
            var data = statement.executeQuery("SELECT * from court_type");
            List<CourtType> listData = new ArrayList<>();
            while (data.next()) {
                listData.add(new CourtType(data));
            }
            data.close();
            statement.close();
            dataConnection.close();
            return listData;
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    public void insert(CourtType court) throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("INSERT INTO court_type (name) VALUES (?)");
            statement.setString(1, court.name);
            statement.execute();

            statement.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    public CourtType getById(int id) throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("SELECT * FROM court_type where id = ? LIMIT 1");
            statement.setInt(1, id);
            var result = statement.executeQuery();
            if (!result.next()) {
                throw new Exception("No Court Type Found");
            }
            statement.close();
            dataConnection.close();
            return new CourtType(result);
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    public void update(int id, CourtType court) throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("UPDATE court_type set name = ?");
            statement.setString(1, court.name);
            statement.executeUpdate();

            statement.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    public void deleteById(int id) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("DELETE FROM court_type where id =?");
            statement.setInt(1, id);
            statement.executeQuery();

            statement.close();
            dataConnection.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }

    }

}
