package controllers;

import models.payment.CreditCardStrategy;
import views.dialogs.CreditCardDialog;
import views.dialogs.PaymentDialog;

public class CreditCardController extends PaymentController implements IPaymentController {

    CreditCardDialog creditCardDialog;

    public CreditCardController(MainController mainController) {
        super(mainController);
    }

    @Override
    public void setDependencies(PaymentDialog paymentDialog) {
        if (paymentDialog instanceof CreditCardDialog) {
            this.creditCardDialog = (CreditCardDialog) paymentDialog;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void initControllerPostDisplay() {
        creditCardDialog.getSubmitBTN().addActionListener(e -> handleSubmitButtonClick());
    }

    private void handleSubmitButtonClick() {

        if (isPaymentAuthorized()) handleSuccessfulPayment();
        else handleFailedPayment();
        closeDialog();
    }

    private boolean isPaymentAuthorized() {
        return mainController.confirmPaymentAuthorization(createCreditCardStrategy());
    }

    private void closeDialog() {
        creditCardDialog.dispose();
    }

    private CreditCardStrategy createCreditCardStrategy() {

        CreditCardStrategy creditCardStrategy = new CreditCardStrategy();
        creditCardStrategy.setName(creditCardDialog.getNameOnCard().getText());
        creditCardStrategy.setNumber(creditCardDialog.getNumber().getText());
        creditCardStrategy.setExpirationDate(creditCardDialog.getExpirationDate().getText());
        creditCardStrategy.setCvc(creditCardDialog.getCode().getText());
        return creditCardStrategy;
    }
}
