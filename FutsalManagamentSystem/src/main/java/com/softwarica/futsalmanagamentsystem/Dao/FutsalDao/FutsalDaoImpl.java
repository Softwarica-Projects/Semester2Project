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
            var data = statement.executeQuery("SELECT f.*, ct.name as court_type_name,(Select COUNT(*) from favourite fav where fav.futsal_id = f.id  and fav.user_id = " + UserProvider.getInstance().getUserId() + " LIMIT 1) as is_favourite\n"
                    + " from futsal f INNER JOIN court_type ct  on ct.id = f.court_type_id");
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
                    .prepareStatement("SELECT f.*,0 as is_favourite,ct.name as court_type_name FROM futsal f"
                            + " INNER JOIN court_type ct on ct.id = f.court_type_id where f.id = ? LIMIT 1");
            statement.setInt(1, id);
            var result = statement.executeQuery();
            if (!result.next()) {
                throw new Exception("No Data Found");
            }
            var data = new Futsal(result);
            return data;
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
                            "INSERT into futsal (name,location,court_type_id,price,opening_hour,closing_hour,created_date,created_by)"
                            + " VALUES (?,?,?,?,?,?,?,?)");
            statement.setString(1, court.name);
            statement.setString(2, court.location);
            statement.setInt(3, court.courtTypeId);
            statement.setDouble(4, court.price);
            statement.setDouble(5, court.openingHour);
            statement.setDouble(6, court.closingHour);
            statement.setDate(7, new java.sql.Date(System.currentTimeMillis()));
            statement.setString(8, UserProvider.getInstance().getName());
            statement.execute();

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
            statement.execute();
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
    public void addFutsalRequest(int userId, Futsal court) throws Exception {
        // TODO Auto-generated method stub
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            dataConnection.setAutoCommit(false);

            var statement = dataConnection
                    .prepareStatement(
                            "INSERT into new_futsal_request (name,location,court_type_id,price,opening_hour,closing_hour,created_date,created_by,user_id)"
                            + " VALUES (?,?,?,?,?,?,?,?,?)");
            statement.setString(1, court.name);
            statement.setString(2, court.location);
            statement.setInt(3, court.courtTypeId);
            statement.setDouble(4, court.price);
            statement.setDouble(5, court.openingHour);
            statement.setDouble(6, court.closingHour);
            statement.setDate(7, new java.sql.Date(System.currentTimeMillis()));
            statement.setString(8, UserProvider.getInstance().getName());
            statement.setInt(9, UserProvider.getInstance().getUserId());
            statement.execute();
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
    public List<Futsal> futsalRequestList() throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {

            var statement = dataConnection.createStatement();
            var data = statement.executeQuery("SELECT f.*,f.id as new_futsal_request_id, ct.name as court_type_name,0 as is_favourite\n"
                    + " from new_futsal_request f INNER JOIN court_type ct on ct.id = f.court_type_id");
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

    @Override
    public void approveFutsalRequest(int userId, int futsalId) throws Exception {
        // TODO Auto-generated method stub
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            dataConnection.setAutoCommit(false);
            var insertStatement = dataConnection
                    .prepareStatement("""
                                      INSERT into futsal (name,location,court_type_id,price,opening_hour,closing_hour,created_date,created_by)
                                      Select name,location,court_type_id,price,opening_hour,closing_hour,created_date,created_by from new_futsal_request WHERE id = ?;""");
            insertStatement.setInt(1, futsalId);
            insertStatement.execute();
            var updateStatement = dataConnection
                    .prepareStatement("""
                                        UPDATE new_futsal_request SET status = 'Approved' WHERE id = ?;""");
            updateStatement.setInt(1, futsalId);
            updateStatement.executeUpdate();
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
    public void rejectFutsalRequest(int userId, int futsalId) throws Exception {
        // TODO Auto-generated method stub
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            dataConnection.setAutoCommit(false);

            var statement = dataConnection
                    .prepareStatement("UPDATE new_futsal_request set status = 'Reject' WHERE id = ?");
            statement.setInt(1, futsalId);
            statement.execute();
            dataConnection.commit();
        } catch (Exception ex) {
            dataConnection.rollback();
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    @Override
    public void deleteFutsalRequest(int futsalId) throws Exception {
        // TODO Auto-generated method stub
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            dataConnection.setAutoCommit(false);

            var statement = dataConnection
                    .prepareStatement("DELETE FROM new_futsal_request WHERE Id = ?");
            statement.setInt(1, futsalId);
            statement.execute();
            dataConnection.commit();
        } catch (Exception ex) {
            dataConnection.rollback();
            throw ex;
        } finally {
            dataConnection.close();
        }
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
                    + "(Select COUNT(*) from favourite f WHERE f.user_id = " + userId + " ) as favourites, \n"
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
