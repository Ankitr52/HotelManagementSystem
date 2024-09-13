package com.system.Dao;

import com.system.entity.Reservation;
import java.util.List;

public interface ReservationDao {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(int reservationId);
    Reservation getReservationById(int reservationId);
    List<Reservation> getAllReservations();
}
