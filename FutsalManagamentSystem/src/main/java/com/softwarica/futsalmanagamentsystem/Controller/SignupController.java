package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDao;
import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.Model.RegisterModel;
import com.softwarica.futsalmanagamentsystem.Model.User;

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

    public void register(RegisterModel registerModel) throws Exception {
        if(registerModel.name.isBlank()){
            throw new Exception("Full name cannot be empty");
        }
        else if(registerModel.username.isBlank()){
            throw new Exception("Username cannot be empty");
        }
        else if(registerModel.password.isBlank()){
            throw new Exception("Password cannot be empty");
        }  else if(!registerModel.password.equals(registerModel.confirmPassword)){
            throw new Exception("Password and confirm password do not match");
        }
//        var user = new RegisterModel("Rishan", "Rishan@123", "Rishan Shrestha", "Balkot", "9860699727");
        authDao.registerUser(registerModel);
    }
}
