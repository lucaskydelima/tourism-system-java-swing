package services;

import models.payment.PaymentStrategy;

import java.util.Optional;

public class PayPalService implements PaymentService {


    @Override
    public boolean authenticate(PaymentStrategy paymentStrategy) {
        return Optional.ofNullable(paymentStrategy).isEmpty();
    }

    @Override
    public void processPayment(PaymentStrategy paymentStrategy) {
    }
}
