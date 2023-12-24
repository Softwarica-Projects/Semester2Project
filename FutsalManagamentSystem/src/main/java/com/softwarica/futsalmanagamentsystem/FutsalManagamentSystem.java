/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.softwarica.futsalmanagamentsystem;

import com.softwarica.futsalmanagamentsystem.Page.CourtType.NewCourtType;
import com.softwarica.futsalmanagamentsystem.model.RegisterModel;
import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDaoImpl;
import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDaoImpl;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.*;
import com.softwarica.futsalmanagamentsystem.Dao.AuthDao.AuthDao;
import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDao;

/**
 *
 * @author Rishan
 */
public class FutsalManagamentSystem {

  public static void main(String[] args) throws Exception {
    try {
      NewCourtType frame = new NewCourtType(0);
      frame.setVisible(false);
      System.out.println(frame.isVisible());
      frame.setVisible(true);
    } catch (Exception ex) {

    }
  }
}
