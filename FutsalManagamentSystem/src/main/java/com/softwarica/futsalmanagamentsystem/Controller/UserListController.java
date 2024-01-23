/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDao;
import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.FavouriteDao.FavouriteDao;
import com.softwarica.futsalmanagamentsystem.Dao.FavouriteDao.FavouriteDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDao;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.GeneralDao.GeneralDao;
import com.softwarica.futsalmanagamentsystem.Dao.GeneralDao.GeneralDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import com.softwarica.futsalmanagamentsystem.Model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rishan
 */
public class UserListController {

    final GeneralDao generalDao = new GeneralDaoImpl();
    final AuthDao authDao = new AuthDaoImpl();
//    final FavouriteDao favouriteDao = new FavouriteDaoImpl();
    public List<User> userList = new ArrayList<>();

    public UserListController() {
        getList();
    }

    public void getList() {
        try {
            userList = generalDao.getUserList();
        } catch (Exception ex) {
            userList = new ArrayList<>();
        }
    }

    public void onDelete(int userId) throws Exception {
        authDao.deleteUser(userId);
    }

}
