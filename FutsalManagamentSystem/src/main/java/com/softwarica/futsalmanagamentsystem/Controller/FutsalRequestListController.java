/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.FavouriteDao.FavouriteDao;
import com.softwarica.futsalmanagamentsystem.Dao.FavouriteDao.FavouriteDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDao;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rishan
 */
public class FutsalRequestListController {

    final FutsalDao futsalDao = new FutsalDaoImpl();
    public List<Futsal> futsalList = new ArrayList<>();
    final UserProvider currentUser = UserProvider.getInstance();

    public FutsalRequestListController() {
        getList();
    }

    public void getList() {
        try {
            futsalList = futsalDao.futsalRequestList();
        } catch (Exception ex) {
            futsalList = new ArrayList<>();
        }
    }

    public void onApprove(int futsalId) throws Exception {
        futsalDao.approveFutsalRequest(currentUser.getUserId(), futsalId);
    }

    public void onReject (int futsalId) throws Exception {
        futsalDao.rejectFutsalRequest(currentUser.getUserId(), futsalId);
    }

    public void onDelete(int futsalId) throws Exception {
        futsalDao.deleteFutsalRequest(futsalId);
    }

}
