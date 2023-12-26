package com.softwarica.futsalmanagamentsystem.Dao.FavouriteDao;

import java.util.List;
import com.softwarica.futsalmanagamentsystem.model.Futsal;

public interface FavouriteDao {

    public List<Futsal> getList() throws Exception;

    public void addToFavourite(int futsalId, int userId) throws Exception;

    public void removeFromFavourite(int futsalId, int userId) throws Exception;

}
