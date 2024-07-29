package services;

import models.payment.PaymentStrategy;

public interface PaymentService {
    boolean authenticate(PaymentStrategy paymentStrategy);

    void processPayment(PaymentStrategy paymentStrategy);
}
