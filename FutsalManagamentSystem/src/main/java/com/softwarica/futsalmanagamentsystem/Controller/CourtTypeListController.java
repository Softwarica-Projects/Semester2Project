package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDao;
import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDaoImpl;
import com.softwarica.futsalmanagamentsystem.Model.CourtType;
import com.softwarica.futsalmanagamentsystem.Utility.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourtTypeListController {
    
    final CourtTypeDao courtTypeDao = new CourtTypeDaoImpl();
    public List<CourtType> courtTypeList = new ArrayList<CourtType>();
    
    public CourtTypeListController() {
        getCourtTypeList();
    }
    
    private void getCourtTypeList() {
        try {
            courtTypeList = courtTypeDao.getList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void onDeleteCourtType(int id) throws Exception {
        courtTypeDao.deleteById(id); 
    }
    
}
