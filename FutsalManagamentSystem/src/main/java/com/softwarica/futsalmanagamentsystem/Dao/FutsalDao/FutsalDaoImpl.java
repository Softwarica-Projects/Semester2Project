package com.softwarica.futsalmanagamentsystem.Dao.FutsalDao;

import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.Database.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.softwarica.futsalmanagamentsystem.Model.BookFutsal;
import com.softwarica.futsalmanagamentsystem.Model.CourtType;
import com.softwarica.futsalmanagamentsystem.Model.DashboardInformation;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import com.softwarica.futsalmanagamentsystem.Model.FutsalBooking;
import java.sql.Date;

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
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            dataConnection.setAutoCommit(false);
            var statement = dataConnection
                    .prepareStatement(
                            "INSERT into futsal (name,location,court_type_id,price,opening_hour,closing_hour,created_date,created_by"
                            + " VALUES (?,?,?,?,?)");
            statement.setString(1, court.name);
            statement.setString(2, court.location);
            statement.setInt(3, court.courtTypeId);
            statement.setDouble(4, court.price);
            statement.setDouble(5, court.openingHour);
            statement.setDouble(6, court.closingHour);
            statement.setDate(7, new java.sql.Date(System.currentTimeMillis())); 
            statement.setString(8, UserProvider.getInstance().getName());
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
    public void update(int id, Futsal court) throws Exception {
Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            dataConnection.setAutoCommit(false);
            var statement = dataConnection
                    .prepareStatement(
                            "UPDATE futsal Set name =?, location =? ,court_type_id=?,price=?,opening_hour=?"
                                    + ",closing_hour=?,modified_date=?,modified_by=?"
                            + " Where id = ?");
            statement.setString(1, court.name);
            statement.setString(2, court.location);
            statement.setInt(3, court.courtTypeId);
            statement.setDouble(4, court.price);
            statement.setDouble(5, court.openingHour);
            statement.setDouble(6, court.closingHour);
            statement.setDate(7, new java.sql.Date(System.currentTimeMillis())); 
            statement.setString(8, UserProvider.getInstance().getName());
            statement.setInt(9, id);
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

    @Override
    public DashboardInformation getDashboardInformation() throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        var statement = dataConnection.createStatement();
        try {
            var isAdmin = UserProvider.getInstance().isAdmin();
            var userId = UserProvider.getInstance().getUserId();

            var data = statement.executeQuery("select (Select COUNT(*) from court_type) as courtType, \n"
                    + "(Select COUNT(*) from `user`) as userList, \n"
                    + "(Select COUNT(*) from futsal) as futsalList, \n"
                    + "(Select COUNT(*) from favourite f" + (isAdmin ? "" : " WHERE f.user_id = " + userId) + " ) as favourites, \n"
                    + "(Select COUNT(*) from futsal_booking f " + (isAdmin ? "WHERE 1 " : " WHERE f.user_id = " + userId) + " AND f.modified_date is null) as bookingRequest, \n"
                    + "(Select COUNT(*) from new_futsal_request f" + (isAdmin ? "" : " WHERE f.user_id = " + userId) + " ) as futsalRequst,\n"
                    + "(Select COUNT(*) from futsal_booking f" + (isAdmin ? "" : " WHERE f.user_id = " + userId) + ") as totalBooking\n"
                    + "\n"
                    + "\n"
                    + " ");
            while (!data.next()) {
                throw new Exception("Error getting data");
            }
            return new DashboardInformation(data);
        } catch (Exception ex) {
            throw ex;
        } finally {
            statement.close();
            dataConnection.close();
        }

    }
}
