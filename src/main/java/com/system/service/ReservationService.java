package com.system.service;

import com.system.entity.Reservation;
import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
    Reservation getReservation(int reservationId);
    Reservation updateReservation(Reservation reservation);
    String deleteReservation(int reservationId);
    List<Reservation> getAllReservations();
	Reservation getReservationById(int reservationId);
}
