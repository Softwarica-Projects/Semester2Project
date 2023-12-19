package com.softwarica.futsalmanagamentsystem.service.FutsalService;

import java.util.List;

import com.softwarica.futsalmanagamentsystem.model.BookFutsal;
import com.softwarica.futsalmanagamentsystem.model.Futsal;
import com.softwarica.futsalmanagamentsystem.model.FutsalBooking;

public interface FutsalService {

    public List<Futsal> getList() throws Exception;

    public void insert(Futsal court) throws Exception;

    public Futsal getById(int id) throws Exception;

    public void update(int id, Futsal court) throws Exception;

    public void deleteById(int id) throws Exception;

    /// ----- Futsal Bookings---------
    public void bookFutsal(int userId, BookFutsal data) throws Exception;

    public List<FutsalBooking> bookingList(int userId) throws Exception;

    public List<FutsalBooking> approveBookingList(int userId) throws Exception;

    public List<FutsalBooking> pendingBookingList(int userId) throws Exception;

    public void approveFutsalBooking(int userId, int futsalId) throws Exception;

    public void rejectFutsalBooking(int userId, int futsalId) throws Exception;

    public void deleteFutsalBooking(int futsalId) throws Exception;

    /// ---New Futsal Request
    public void addFutsalRequest(int userId, Futsal data) throws Exception;

    public List<Futsal> futsalRequestList(int userId) throws Exception;

    public void approveFutsalRequest(int userId, int futsalId) throws Exception;

    public void rejectFutsalRequest(int userId, int futsalId) throws Exception;

    public void deleteFutsalRequest(int futsalId) throws Exception;

}
