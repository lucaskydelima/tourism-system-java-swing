package controllers;

import models.payment.PayPalStrategy;
import views.dialogs.PayPalDialog;
import views.dialogs.PaymentDialog;

public class PayPalController extends PaymentController implements IPaymentController {

    PayPalDialog payPalDialog;

    public PayPalController(MainController mainController) {
        super(mainController);
    }

    @Override
    public void setDependencies(PaymentDialog paymentDialog) {
        if (paymentDialog instanceof PayPalDialog) {
            this.payPalDialog = (PayPalDialog) paymentDialog;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void initControllerPostDisplay() {
        payPalDialog.getSubmitBTN().addActionListener(e -> handleSubmitButtonClick());
    }

    private void handleSubmitButtonClick() {

        if (isPaymentAuthorized()) handleSuccessfulPayment();
        else handleFailedPayment();
        closeDialog();
    }

    private boolean isPaymentAuthorized() {
        return mainController.confirmPaymentAuthorization(createPayPalStrategy());
    }

    private void closeDialog() {
        payPalDialog.dispose();
    }

    private PayPalStrategy createPayPalStrategy() {
        PayPalStrategy payPalStrategy = new PayPalStrategy();
        payPalStrategy.setEmail(payPalDialog.getEmail().getText());
        payPalStrategy.setPassword(payPalDialog.getPasswordField().getPassword());
        return payPalStrategy;
    }
}
