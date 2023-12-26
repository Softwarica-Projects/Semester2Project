package com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao;

import com.softwarica.futsalmanagamentsystem.Database.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import com.softwarica.futsalmanagamentsystem.Model.CourtType;
import java.sql.SQLException;

public class CourtTypeDaoImpl implements CourtTypeDao {

    @Override
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
            return listData;
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    @Override
    public CourtType getById(int id) throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        final PreparedStatement statement = dataConnection
                    .prepareStatement("SELECT * FROM court_type where id = ? LIMIT 1");
        try {
            statement.setInt(1, id);
            var result = statement.executeQuery();
            if (!result.next()) {
                throw new Exception("No Court Type Found");
            }
          return new CourtType(result);
        } catch (Exception ex) {
            throw ex;
        } finally {
            statement.close();
            dataConnection.close();
        }
    }

    @Override
    public void update(int id, CourtType court) throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("UPDATE court_type set name = ?");
            statement.setString(1, court.name);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("DELETE FROM court_type where id =?");
            statement.setInt(1, id);
            statement.executeQuery();

            statement.close();
            dataConnection.close();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }

    }

}
