package com.system.daoimp;

import com.system.entity.Payment;
import com.system.Dao.PaymentDao;
import com.system.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    @Override
    public Payment addPayment(Payment payment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.persist(payment);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public Payment updatePayment(Payment payment) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.merge(payment);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public void deletePayment(int paymentId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            Payment payment = session.get(Payment.class, paymentId);
            if (payment != null) {
                session.remove(payment);
                transaction.commit();
            }
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        Payment payment = null;
        try (Session session = HibernateUtil.getSession()) {
            payment = session.get(Payment.class, paymentId);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return payment;
    }

    @Override
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            Query<Payment> query = session.createQuery("FROM Payment", Payment.class);
            payments = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
