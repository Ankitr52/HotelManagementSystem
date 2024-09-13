package com.system.daoimp;

import com.system.entity.Guest;
import com.system.Dao.GuestDao;
import com.system.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class GuestDaoImpl implements GuestDao {

    @Override
    public Guest addGuest(Guest guest) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.persist(guest);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return guest;
    }

    @Override
    public Guest updateGuest(Guest guest) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.merge(guest);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return guest;
    }

    @Override
    public void deleteGuest(int guestId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Guest guest = session.get(Guest.class, guestId);
            if (guest != null) {
            	session.remove(guest);
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Guest getGuestById(int guestId) {
        Guest guest = null;
        try (Session session = HibernateUtil.getSession()) {
            guest = session.get(Guest.class, guestId);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return guest;
    }

    @Override
    public List<Guest> getAllGuests() {
        List<Guest> guests = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            Query<Guest> query = session.createQuery("FROM Guest", Guest.class);
            guests = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return guests;
    }
}
