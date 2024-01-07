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
import com.softwarica.futsalmanagamentsystem.Model.FutsalBooking;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rishan
 */
public class FutsalBookingListController {

    final FutsalDao futsalDao = new FutsalDaoImpl();
    public List<FutsalBooking> dataList = new ArrayList<>();

    public FutsalBookingListController() {
        getList();
    }

    public void getList() {
        try {
            dataList = futsalDao.bookingList();
        } catch (Exception ex) {
            dataList = new ArrayList<>();
        }
    }

    public void approveBooking(int id) throws Exception {
        futsalDao.approveFutsalBooking(id);
    }

    public void onDelete(int id) throws Exception {
        futsalDao.deleteFutsalBooking(id);
    }

    public void onReject(int id) throws Exception {
        futsalDao.rejectFutsalBooking(id);
    }

}
