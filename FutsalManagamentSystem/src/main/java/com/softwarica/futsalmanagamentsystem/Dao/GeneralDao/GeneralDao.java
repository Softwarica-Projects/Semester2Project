/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softwarica.futsalmanagamentsystem.Dao.GeneralDao;

import com.softwarica.futsalmanagamentsystem.Model.DashboardInformation;
import com.softwarica.futsalmanagamentsystem.Model.User;
import com.softwarica.futsalmanagamentsystem.Model.UserListModel;
import java.util.List;

/**
 *
 * @author Rishan
 */
public  interface GeneralDao {

    List<UserListModel> getUserListForSelection() throws Exception;

    List<User> getUserList() throws Exception;

    DashboardInformation getDashboardInformation() throws Exception;
}
