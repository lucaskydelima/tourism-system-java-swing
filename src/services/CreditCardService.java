package services;

import models.payment.PaymentStrategy;

import java.util.Optional;

public class CreditCardService implements PaymentService {


    @Override
    public boolean authenticate(PaymentStrategy paymentStrategy) {
        return Optional.ofNullable(paymentStrategy).isPresent();
    }

    @Override
    public void processPayment(PaymentStrategy paymentStrategy) {
    }
}
