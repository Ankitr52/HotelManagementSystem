package com.system;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.system.entity.Room;
import com.system.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {//get sessionFactory
    	SessionFactory factory=HibernateUtil.getSessionFactory();
    	//create a session(connection)
    	Session session=factory.openSession();
    	
    	//Begin a Transaction
    	Transaction tx=session.beginTransaction();
    	
    	//transient state
    	Room room1 = new Room(1, "R102", "Simple", 1500.00, "Available");
        Room room2 = new Room(2, "R103", "Double", 2000.00, "Occupied");
    	
    	
    	//save the Student Object(insert query will execute)
    	
    	session.persist(room1);//persistent state
    	session.persist(room2);
    	
    	//commit the transaction
    	 tx.commit();
    	
    	//fetch the object
    	Room room=session.get(Room.class, 1);
     	System.out.println(room.getAvailabilityStatus());
    	
    	//close session
    	session.close();
    	
    	//close Session factory
    	
    	factory.close();
    }
}

