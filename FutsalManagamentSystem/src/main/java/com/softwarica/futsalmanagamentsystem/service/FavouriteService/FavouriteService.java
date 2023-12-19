package com.softwarica.futsalmanagamentsystem.service.FavouriteService;

import java.util.List;
import com.softwarica.futsalmanagamentsystem.model.Futsal;

public interface FavouriteService {

    public List<Futsal> getList() throws Exception;

    public void addToFavourite(int futsalId, int userId) throws Exception;

    public void removeFromFavourite(int futsalId, int userId) throws Exception;

}
