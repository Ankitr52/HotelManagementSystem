package com.system.daoimp;

import com.system.entity.Reservation;
import com.system.Dao.ReservationDao;
import com.system.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {

    @Override
    public Reservation addReservation(Reservation reservation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.persist(reservation);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.merge(reservation);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public void deleteReservation(int reservationId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, reservationId);
            if (reservation != null) {
                session.remove(reservation);
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        Reservation reservation = null;
        try (Session session = HibernateUtil.getSession()) {
            reservation = session.get(Reservation.class, reservationId);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            Query<Reservation> query = session.createQuery("FROM Reservation", Reservation.class);
            reservations = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
