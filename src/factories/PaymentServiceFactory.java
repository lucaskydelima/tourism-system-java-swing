package factories;

import enums.PaymentType;
import services.CreditCardService;
import services.PayPalService;
import services.PaymentService;

import java.util.HashMap;

public class PaymentServiceFactory {

    public static final HashMap<PaymentType, PaymentService> paymentServiceMap = new HashMap<>();

    static {
        paymentServiceMap.put(PaymentType.CREDIT_CARD, new CreditCardService());
        paymentServiceMap.put(PaymentType.PAY_PAL, new PayPalService());
    }

    public static PaymentService createPaymentService(String type) {
        return paymentServiceMap.get(PaymentType.valueOf(type));
    }
}
