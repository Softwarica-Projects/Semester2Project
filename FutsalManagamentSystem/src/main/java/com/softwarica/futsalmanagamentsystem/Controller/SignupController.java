package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDao;
import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.model.RegisterModel;
import com.softwarica.futsalmanagamentsystem.model.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rishan
 */
public class SignupController {
    final AuthDao authDao = new AuthDaoImpl();

    public void register(String username, String password) throws Exception {
        var user = new RegisterModel("Rishan", "Rishan@123", "Rishan Shrestha", "Balkot", "9860699727");
        authDao.registerUser(user);
    }
}
