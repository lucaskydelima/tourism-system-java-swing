package factories;

import enums.PaymentType;
import models.payment.CreditCardStrategy;
import models.payment.PayPalStrategy;
import models.payment.PaymentStrategy;

import java.util.HashMap;

public class PaymentStrategyFactory {

    public static final HashMap<PaymentType, PaymentStrategy> paymentMap = new HashMap<>();

    static {
        paymentMap.put(PaymentType.PAY_PAL, new PayPalStrategy());
        paymentMap.put(PaymentType.CREDIT_CARD, new CreditCardStrategy());
    }

    public static PaymentStrategy createPaymentStrategy(String type) {
        return paymentMap.get(PaymentType.valueOf(type));
    }
}
