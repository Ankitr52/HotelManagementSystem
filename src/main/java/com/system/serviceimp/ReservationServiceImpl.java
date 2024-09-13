package com.system.serviceimp;

import com.system.Dao.ReservationDao;
import com.system.daoimp.ReservationDaoImpl;
import com.system.entity.Reservation;
import com.system.service.ReservationService;

import java.util.List;


public class ReservationServiceImpl implements ReservationService {

    private ReservationDao reservationDao; // Dependency Injection of ReservationDao
    
    public ReservationServiceImpl() {
        this.reservationDao = new ReservationDaoImpl(); // Or any default initialization
    }

    // Constructor Injection (can also use Setter Injection or Dependency Injection frameworks)
    public ReservationServiceImpl(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        // Delegate to DAO to add the reservation
        return reservationDao.addReservation(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        // Delegate to DAO to update the reservation
        return reservationDao.updateReservation(reservation);
    }

    @Override
    public String deleteReservation(int reservationId) {
        // Delegate to DAO to delete the reservation
        reservationDao.deleteReservation(reservationId);
		return null;
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        // Delegate to DAO to retrieve a reservation by ID
        return reservationDao.getReservationById(reservationId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        // Delegate to DAO to get all reservations
        return reservationDao.getAllReservations();
    }

	@Override
	public Reservation getReservation(int reservationId) {
		// TODO Auto-generated method stub
		return null;
	}
}
