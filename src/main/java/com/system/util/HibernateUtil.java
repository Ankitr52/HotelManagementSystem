package com.system.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.system.entity.Room;
import com.system.entity.Guest;
import com.system.entity.Reservation;
import com.system.entity.Payment;
import com.system.entity.Staff;
import com.system.entity.User;

public class HibernateUtil {
	
	private final static SessionFactory sessionFactory=buildSessionFactory();
private static SessionFactory buildSessionFactory()
{

	try {
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Room.class)
				.addAnnotatedClass(Guest.class)
				.addAnnotatedClass(Reservation.class)
				.addAnnotatedClass(Payment.class)
				.addAnnotatedClass(Staff.class)
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		
	}catch (Throwable e) {
		throw new ExceptionInInitializerError(e);
	}
}

public static SessionFactory getSessionFactory() {
	return sessionFactory;
}

public static Session getSession()
{
  return getSessionFactory().openSession(); //session opened
}
	
}
