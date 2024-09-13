package com.system.daoimp;

import com.system.entity.Staff;
import com.system.Dao.StaffDao;
import com.system.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {

    @Override
    public Staff addStaff(Staff staff) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.persist(staff); // Use persist for new entities
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
		return staff;
    }

    @Override
    public Staff updateStaff(Staff staff) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.merge(staff); // Use merge to update existing entities
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
		return staff;
    }

    @Override
    public void deleteStaff(int staffId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Staff staff = session.get(Staff.class, staffId);
            if (staff != null) {
                session.remove(staff); // Remove the entity if it exists
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Staff getStaffById(int staffId) {
        Staff staff = null;
        try (Session session = HibernateUtil.getSession()) {
            staff = session.get(Staff.class, staffId);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return staff;
    }

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            Query<Staff> query = session.createQuery("FROM Staff", Staff.class);
            staffList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return staffList;
    }
}
