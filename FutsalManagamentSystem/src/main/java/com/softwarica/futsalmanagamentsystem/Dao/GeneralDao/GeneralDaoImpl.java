/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softwarica.futsalmanagamentsystem.Dao.GeneralDao;

import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.Database.DatabaseConnector;
import com.softwarica.futsalmanagamentsystem.Model.DashboardInformation;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import com.softwarica.futsalmanagamentsystem.Model.User;
import com.softwarica.futsalmanagamentsystem.Model.UserListModel;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rishan
 */
public class GeneralDaoImpl implements GeneralDao {

    public List<User> getUserList() throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            var statement = dataConnection.createStatement();
            var data = statement.executeQuery("SELECT * from user where is_admin = 0");
            List<User> listData = new ArrayList<>();
            while (data.next()) {
                listData.add(new User(data));
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
    public DashboardInformation getDashboardInformation() throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        var statement = dataConnection.createStatement();
        try {
            var isAdmin = UserProvider.getInstance().isAdmin();
            var userId = UserProvider.getInstance().getUserId();

            var data = statement.executeQuery("""
                                              select (Select COUNT(*) from court_type) as courtType, 
                                              (Select COUNT(*) from `user`) as userList, 
                                              (Select COUNT(*) from futsal) as futsalList, 
                                              (Select COUNT(*) from favourite f WHERE f.user_id = """ + userId + " ) as favourites, \n"
                    + "(Select COUNT(*) from futsal_booking f WHERE" + (isAdmin ? "" : " f.user_id = " + userId + " AND") + " f.is_approved is null) as bookingRequest, \n"
                    + "(Select COUNT(*) from new_futsal_request f" + (isAdmin ? "" : " WHERE f.user_id = " + userId) + " ) as futsalRequst,\n"
                    + "(Select COUNT(*) from futsal_booking f WHERE" + (isAdmin ? "" : " f.user_id = " + userId + " AND") + " f.is_approved = 1)  as totalBooking \n"
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

    @Override
    public List<UserListModel> getUserListForSelection() throws Exception {
        final Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            var statement = dataConnection.createStatement();
            var data = statement.executeQuery("SELECT u.id, u.name from user u where is_admin = 0");
            List<UserListModel> listData = new ArrayList<>();
            while (data.next()) {
                listData.add(new UserListModel(data));
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
}
