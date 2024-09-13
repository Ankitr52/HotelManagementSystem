package com.system.serviceimp;

import com.system.Dao.PaymentDao;
import com.system.daoimp.PaymentDaoImpl;
import com.system.entity.Payment;
import com.system.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao; 
    
 // Default constructor
    public PaymentServiceImpl() {
        this.paymentDao = new PaymentDaoImpl(); // Or any default initialization
    }


    // Constructor Injection (you can also use Setter Injection or Dependency Injection frameworks)
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment addPayment(Payment payment) {
        // Delegate to DAO to add the payment
        return paymentDao.addPayment(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        // Delegate to DAO to update the payment
        return paymentDao.updatePayment(payment);
    }

    @Override
    public String deletePayment(int paymentId) {
        // Delegate to DAO to delete the payment
        paymentDao.deletePayment(paymentId);
		return null;
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        // Delegate to DAO to retrieve a payment by ID
        return paymentDao.getPaymentById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        // Delegate to DAO to get all payments
        return paymentDao.getAllPayments();
    }


	@Override
	public Payment getPayment(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}
}
