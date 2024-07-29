package facades;

import models.payment.PaymentStrategy;

public interface PaymentFacade {

    boolean isAuthorized(PaymentStrategy paymentStrategy);
    void processPayment();


}
