package controllers;

import views.dialogs.PaymentDialog;

public interface IPaymentController {

    void initControllerPostDisplay();

    void setDependencies(PaymentDialog paymentDialog);
}
