package com.softwarica.futsalmanagamentsystem.Dao.FutsalDao;

import com.softwarica.futsalmanagamentsystem.Database.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.softwarica.futsalmanagamentsystem.Model.BookFutsal;
import com.softwarica.futsalmanagamentsystem.Model.CourtType;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import com.softwarica.futsalmanagamentsystem.Model.FutsalBooking;

public class FutsalDaoImpl implements FutsalDao {

    public List<Futsal> getList() throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {

            var statement = dataConnection.createStatement();
            var data = statement.executeQuery("SELECT * from futsal");
            List<Futsal> listData = new ArrayList<>();
            while (data.next()) {
                listData.add(new Futsal(data));
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

    public Futsal getById(int id) throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            final PreparedStatement statement = dataConnection
                    .prepareStatement("SELECT * FROM futsal where id = ? LIMIT 1");
            statement.setInt(1, id);
            var result = statement.executeQuery();
            if (!result.next()) {
                throw new Exception("No Court Type Found");
            }
            statement.close();
            dataConnection.close();
            return new Futsal(result);
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    public void deleteById(int id) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            dataConnection.setAutoCommit(false);
            final Statement statement = dataConnection
                    .createStatement();
            statement.execute("DELETE FROM futsal where id = " + id);
            statement.execute("DELETE FROM futsal_booking where futsal_id = " + id);
            statement.execute("DELETE FROM favourite where futsal_id = " + id);
            statement.close();
            dataConnection.commit();
            dataConnection.close();
        } catch (Exception ex) {
            dataConnection.rollback();
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    @Override
    public void insert(Futsal court) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(int id, Futsal court) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void bookFutsal(int userId, BookFutsal data) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bookFutsal'");
    }

    @Override
    public List<FutsalBooking> bookingList(int userId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bookingList'");
    }

    @Override
    public List<FutsalBooking> approveBookingList(int userId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'approveBookingList'");
    }

    @Override
    public List<FutsalBooking> pendingBookingList(int userId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pendingBookingList'");
    }

    @Override
    public void approveFutsalBooking(int userId, int futsalId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'approveFutsalBooking'");
    }

    @Override
    public void rejectFutsalBooking(int userId, int futsalId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rejectFutsalBooking'");
    }

    @Override
    public void deleteFutsalBooking(int futsalId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFutsalBooking'");
    }

    @Override
    public void addFutsalRequest(int userId, Futsal data) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFutsalRequest'");
    }

    @Override
    public List<Futsal> futsalRequestList(int userId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'futsalRequestList'");
    }

    @Override
    public void approveFutsalRequest(int userId, int futsalId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'approveFutsalRequest'");
    }

    @Override
    public void rejectFutsalRequest(int userId, int futsalId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rejectFutsalRequest'");
    }

    @Override
    public void deleteFutsalRequest(int futsalId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFutsalRequest'");
    }

}
