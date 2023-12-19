package com.softwarica.futsalmanagamentsystem.service.AuthService;

import com.softwarica.futsalmanagamentsystem.model.RegisterModel;
import com.softwarica.futsalmanagamentsystem.model.User;

public interface AuthService {

    public User loginUser(String username, String password) throws Exception;

    public void registerUser(RegisterModel registerModel) throws Exception;

    public void registerAdmin(RegisterModel registerModel) throws Exception;

    public void deleteUser(int userId) throws Exception;

}
