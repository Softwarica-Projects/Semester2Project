package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDao;
import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDao;
import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDao;
import com.softwarica.futsalmanagamentsystem.Dao.FutsalDao.FutsalDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.UserProvider;
import com.softwarica.futsalmanagamentsystem.Model.CourtType;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import com.softwarica.futsalmanagamentsystem.Model.RegisterModel;
import com.softwarica.futsalmanagamentsystem.Model.User;
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
public class NewFutsalController {

    final FutsalDao futsalDao = new FutsalDaoImpl();
    final CourtTypeDao courtTypeDao = new CourtTypeDaoImpl();
    public int id = 0;
    public Futsal futsalDetail;
    public List<CourtType> courtTypeList = new ArrayList<>();

    public NewFutsalController(int id) {
        this.id = id;
        if (id > 0) {
            getFutsalDetail();
        }
        try {
            courtTypeList = courtTypeDao.getList();
        } catch (Exception ex) {
        }
    }

    private void getFutsalDetail() {
        try {
            this.futsalDetail = futsalDao.getById(id);
        } catch (Exception ex) {

        }
    }

    public void onSubmit(Futsal data) throws Exception {
        if (data.name.isBlank()) {
            throw new Exception("Name cannot be empty");
        } else if (data.location.isBlank()) {
            throw new Exception("Location  cannot be empty");
        } else if (data.openingHour < 1) {
            throw new Exception("Opening Hour is required");
        } else if (data.closingHour < 1) {
            throw new Exception("Closing Hour is required");
        }
        if (UserProvider.getInstance().isAdmin()) {
            if (id > 1) {
                futsalDao.update(id, data);
            } else {
                futsalDao.insert(data);
            }
        } 
        else {
            futsalDao.addFutsalRequest(UserProvider.getInstance().getUserId(), data);
        }
    }
}
