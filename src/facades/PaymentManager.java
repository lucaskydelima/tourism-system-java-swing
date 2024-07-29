package facades;

import factories.PaymentServiceFactory;
import models.payment.PaymentStrategy;
import services.PaymentService;

public class PaymentManager implements PaymentFacade {

    PaymentService paymentService;
    PaymentStrategy paymentStrategy;

    @Override
    public void processPayment() {
        paymentService.processPayment(paymentStrategy);
    }

    @Override
    public boolean isAuthorized(PaymentStrategy paymentStrategy) {
        setPaymentService(paymentStrategy);
        setPaymentStrategy(paymentStrategy);
        return paymentService.authenticate(paymentStrategy);
    }

    private void setPaymentService(PaymentStrategy paymentStrategy) {
        this.paymentService = PaymentServiceFactory.createPaymentService(paymentStrategy.toString());
    }

    private void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}

