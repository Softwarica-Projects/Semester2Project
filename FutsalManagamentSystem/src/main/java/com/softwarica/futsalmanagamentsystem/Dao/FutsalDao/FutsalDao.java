package com.softwarica.futsalmanagamentsystem.Dao.FutsalDao;

import java.util.List;
import com.softwarica.futsalmanagamentsystem.Model.BookFutsal;
import com.softwarica.futsalmanagamentsystem.Model.Futsal;
import com.softwarica.futsalmanagamentsystem.Model.FutsalBooking;

public interface FutsalDao {

    public List<Futsal> getList() throws Exception;

    public void insert(Futsal court) throws Exception;

    public Futsal getById(int id) throws Exception;

    public void update(int id, Futsal court) throws Exception;

    public void deleteById(int id) throws Exception;

    /// ----- Futsal Bookings---------
    public void bookFutsal(int userId, BookFutsal data) throws Exception;

    public List<FutsalBooking> bookingList() throws Exception;

    public void approveFutsalBooking(int id) throws Exception;

    public void rejectFutsalBooking(int id) throws Exception;

    public void deleteFutsalBooking(int futsalId) throws Exception;

    /// ---New Futsal Request
    public void addFutsalRequest(int userId, Futsal data) throws Exception;

    public List<Futsal> futsalRequestList() throws Exception;

    public void approveFutsalRequest(int userId, int futsalId) throws Exception;

    public void rejectFutsalRequest(int userId, int futsalId) throws Exception;

    public void deleteFutsalRequest(int futsalId) throws Exception;

}
