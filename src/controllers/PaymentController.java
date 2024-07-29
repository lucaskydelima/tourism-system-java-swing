package controllers;

import views.options.Option;

public abstract class PaymentController {

    private static final String PAYMENT_APPROVED_MESSAGE = "Your payment has been approved! Thank you for your purchase.";
    private static final String PAYMENT_DENIED_MESSAGE = "Your payment has been denied. Please check your payment details and try again.";
    private static final String PAYMENT_APPROVED_TITLE = "Payment Approved";
    private static final String PAYMENT_DENIED_TITLE = "Payment Denied";
    MainController mainController;

    public PaymentController(MainController mainController) {
        this.mainController = mainController;

    }

    public void handleSuccessfulPayment() {
        processPayment();
        showPaymentApprovedMessage();
        resetForSuccessfulPayment();

    }

    public void handleFailedPayment() {
        showPaymentDeniedMessage();
        handlePaymentDenial();
    }

    public void processPayment() {
        mainController.handlePaymentProcessing();
    }

    public void showPaymentApprovedMessage() {
        Option.showInformationMessage(PAYMENT_APPROVED_MESSAGE, PAYMENT_APPROVED_TITLE);
    }

    public void showPaymentDeniedMessage() {
        Option.showErrorMessage(PAYMENT_DENIED_MESSAGE, PAYMENT_DENIED_TITLE);
    }

    public void handlePaymentDenial() {
        mainController.enablePaymentMethodPanelFields(true);
        mainController.handlePaymentDenial();
    }

    public void resetForSuccessfulPayment() {
        mainController.clearAllSelectionsInPanels();
        mainController.enablePanelComponents(true);
        mainController.enableConfirmButtonInAgencyPanel(false);
    }
}

