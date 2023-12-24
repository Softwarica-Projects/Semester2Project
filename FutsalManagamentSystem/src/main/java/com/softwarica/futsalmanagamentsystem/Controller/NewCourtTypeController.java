package com.softwarica.futsalmanagamentsystem.Controller;

import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDao;
import com.softwarica.futsalmanagamentsystem.Dao.CourtTypeDao.CourtTypeDaoImpl;
import com.softwarica.futsalmanagamentsystem.model.CourtType;

public class NewCourtTypeController {
    final CourtTypeDao courtTypeDao = new CourtTypeDaoImpl();
    public String nameField="";
    public int id;
    
    public String pageTitle="New Court Type";

    public NewCourtTypeController(int id) {
        this.id = id;
        System.out.println(this.id);
        if (this.id != 0) {
            pageTitle="Edit Court Type";
            getCourtData();
        }
    }

    private void getCourtData() {
        try {
            var data = courtTypeDao.getById(id);
            nameField = data.name;
            System.out.println(data.name);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String submit() throws Exception{
        var data = new CourtType(0,nameField);
        if(id>0){
           
            courtTypeDao.update(id, data);
            return "Court type has been updated";
        }
        else {
            courtTypeDao.insert(data);
            
            return "Court type has been added";
        }
    }
}
