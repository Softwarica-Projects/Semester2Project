package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDao;
import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDao;
import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDao;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.GeneralDao.GeneralDao;
import com.softwarica.futsalmanagamentsystem.Dao.GeneralDao.GeneralDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.Model.BookFutsal;
import com.softwarica.futsalmanagamentsystem.Model.CourtType;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import com.softwarica.futsalmanagamentsystem.Model.RegisterModel;
import com.softwarica.futsalmanagamentsystem.Model.User;
import com.softwarica.futsalmanagamentsystem.Model.UserListModel;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Rishan
 */
public class FutsalBookController {

    public List<UserListModel> userList = new ArrayList();
    final GeneralDao generalDao = new GeneralDaoImpl();
    final FutsalDao futsalDao = new FutsalDaoImpl();
    final int id;

    public FutsalBookController(int id) {
        this.id = id;
        getUserList();
    }

    private void getUserList() {
        try {
            userList = generalDao.getUserListForSelection();
        } catch (Exception ex) {
            System.out.println("");
        }

    }

    public void onSubmit(String bookingDate, int bookingHour, int userId) throws Exception {
        var data = new BookFutsal(id, bookingDate, bookingHour, userId);
        if (data.bookingDateTime.isBlank()) {
            throw new Exception("Booking Date is required");
        } else if (data.bookingHour < 1) {
            throw new Exception("Booking hours must be greator than 1");
        }
        futsalDao.bookFutsal(userId > 0 ? userId :  UserProvider.getInstance().getUserId(), data);
    }
}
