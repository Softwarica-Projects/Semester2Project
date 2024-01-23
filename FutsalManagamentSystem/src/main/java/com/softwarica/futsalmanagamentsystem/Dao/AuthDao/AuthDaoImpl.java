package com.softwarica.futsalmanagamentsystem.Dao.AuthDao;

import com.softwarica.futsalmanagamentsystem.Database.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.softwarica.futsalmanagamentsystem.Model.RegisterModel;
import com.softwarica.futsalmanagamentsystem.Model.User;

public class AuthDaoImpl implements AuthDao {

    @Override
    public User loginUser(String username, String password) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        final PreparedStatement statement = dataConnection
                .prepareStatement("SELECT * FROM user where username = ? AND password = ? LIMIT 1");
        statement.setString(1, username);
        statement.setString(2, password);
        try {
            boolean isExists = checkIfUserExists(dataConnection, username);
            if (!isExists) {
                throw new Exception("User with username " + username + " doesnot exists");
            }
            final var response = statement.executeQuery();
            if (response.next()) {
                return new User(response);
            }
            statement.close();
            throw new Exception("Username or password is invalid, Please try again");
        } catch (Exception ex) {
            throw ex;
        } finally {
            statement.close();
            dataConnection.close();
        }
    }

    @Override
    public void registerUser(RegisterModel registerModel) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            boolean isExists = checkIfUserExists(dataConnection, registerModel.username);
            if (isExists) {
                throw new Exception("User with username " + registerModel.username + " already exists");
            }

            final PreparedStatement statement = dataConnection
                    .prepareStatement(
                            "INSERT INTO user (name,username,password,phoneNumber,address) VALUES (?,?,?,?,?)");
            statement.setString(1, registerModel.name);
            statement.setString(2, registerModel.username);
            statement.setString(3, registerModel.password);
            statement.setString(4, registerModel.phoneNumber);
            statement.setString(5, registerModel.address);
            statement.execute();
            statement.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    @Override
    public void registerAdmin(RegisterModel registerModel) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            boolean isExists = checkIfUserExists(dataConnection, registerModel.username);
            if (isExists) {
                throw new Exception("User with username " + registerModel.username + " already exists");
            }
            final PreparedStatement statement = dataConnection
                    .prepareStatement(
                            "INSERT INTO user (name,username,password,phoneNumber,address,is_admin) VALUES (?,?,?,?,?,1)");
            statement.setString(1, registerModel.name);
            statement.setString(2, registerModel.username);
            statement.setString(3, registerModel.password);
            statement.setString(4, registerModel.phoneNumber);
            statement.setString(5, registerModel.address);
            statement.execute();
            statement.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    @Override
    public void deleteUser(int userId) throws Exception {
        Connection dataConnection = DatabaseConnector.getDatabaseConnection();
        try {
            dataConnection.setAutoCommit(false);
            var statement = dataConnection.createStatement();
            statement.addBatch("DELETE FROM favourite WHERE user_id = " + userId);
            statement.addBatch("DELETE FROM futsal_booking WHERE user_id = " + userId);
            statement.addBatch("DELETE FROM new_futsal_request WHERE user_id = " + userId);
            statement.addBatch("DELETE FROM user WHERE id = " + userId);
            statement.executeBatch();
            dataConnection.commit();
            statement.close();
        } catch (Exception ex) {
            dataConnection.rollback();
            throw ex;
        } finally {
            dataConnection.close();
        }
    }

    private Boolean checkIfUserExists(Connection dataConnection, String username) throws SQLException {
        final PreparedStatement statement = dataConnection
                .prepareStatement("SELECT COUNT(id) as count FROM user where username = ? LIMIT 1");
        statement.setString(1, username);
        final var response = statement.executeQuery();
        final boolean data = (response.next() && response.getInt("count") > 0);
        statement.close();
        return data;
    }
}
