package com.softwarica.futsalmanagamentsystem.Dao.AuthDao;

import com.softwarica.futsalmanagamentsystem.Model.RegisterModel;
import com.softwarica.futsalmanagamentsystem.Model.User;

public interface AuthDao {

    public User loginUser(String username, String password) throws Exception;

    public void registerUser(RegisterModel registerModel) throws Exception;

    public void registerAdmin(RegisterModel registerModel) throws Exception;

    public void deleteUser(int userId) throws Exception;

}
