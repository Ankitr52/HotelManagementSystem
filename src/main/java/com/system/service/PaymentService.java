package com.system.service;

import com.system.entity.Payment;
import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment payment);
    Payment getPayment(int paymentId);
    Payment updatePayment(Payment payment);
    String deletePayment(int paymentId);
    List<Payment> getAllPayments();
	Payment getPaymentById(int paymentId);
}
