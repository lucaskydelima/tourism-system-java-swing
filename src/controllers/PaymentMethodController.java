package controllers;

import factories.PaymentStrategyFactory;
import models.payment.PaymentStrategy;
import views.panels.PaymentMethodPanel;

import java.util.stream.Stream;

public class PaymentMethodController {

    public static final String TOTAL_PRICE_LABEL = "Total Price: USD ";
    public static final String TOTAL_PRICE_BEFORE_DISCOUNT_LABEL = "Total Price Before Discount: USD ";
    public static final String TOTAL_PRICE_AFTER_DISCOUNT_LABEL = "Total Price After Discount: USD ";

    PaymentMethodPanel paymentMethodPanel;

    MainController mainController;

    public void setDependencies(PaymentMethodPanel paymentMethodPanel, MainController mainController) {
        this.paymentMethodPanel = paymentMethodPanel;
        this.mainController = mainController;
    }

    public void clearTextArea() {
        paymentMethodPanel.getTotalPriceArea().setText(TOTAL_PRICE_LABEL);
    }

    public PaymentStrategy createPaymentStrategyFromSelection() {
        return PaymentStrategyFactory.createPaymentStrategy(this.getPaymentMethodSelection());
    }

    public void clearFields() {
        this.clearTextArea();
        paymentMethodPanel.getG2().clearSelection();
    }

    public void setAllFieldsEnabled(boolean isEnabled) {
        paymentMethodPanel.getPayment1RadioBTN().setEnabled(isEnabled);
        paymentMethodPanel.getPayment2RadioBTN().setEnabled(isEnabled);
    }


    public boolean areAllRequiredFieldsProvided() {
        return Stream.of(paymentMethodPanel.getPayment1RadioBTN(), paymentMethodPanel.getPayment2RadioBTN())
                .anyMatch(radioButton -> !radioButton.isEnabled() || radioButton.isSelected());
    }

    public void displayTotalPackagePrice(int totalPrice) {
        paymentMethodPanel.getTotalPriceArea().setText(TOTAL_PRICE_LABEL + totalPrice);
    }


    public void displayTotalPriceWithDiscount(int totalPrice) {
        int discountedPrice = mainController.getDiscountedPrice(totalPrice);

        paymentMethodPanel.getTotalPriceArea().setText(TOTAL_PRICE_BEFORE_DISCOUNT_LABEL + totalPrice + "\n"
                + TOTAL_PRICE_AFTER_DISCOUNT_LABEL + discountedPrice);
    }

    public String getPaymentMethodSelection() {
        return paymentMethodPanel.getG2().getSelection().getActionCommand();
    }

}
