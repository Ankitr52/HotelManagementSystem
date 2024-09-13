package com.system.Dao;

import com.system.entity.Payment;
import java.util.List;

public interface PaymentDao {
    Payment addPayment(Payment payment);
    Payment updatePayment(Payment payment);
    void deletePayment(int paymentId);
    Payment getPaymentById(int paymentId);
    List<Payment> getAllPayments();
}
