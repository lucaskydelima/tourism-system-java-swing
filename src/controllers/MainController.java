package controllers;

import facades.PaymentManager;
import facades.ReservationManager;
import factories.PaymentDialogFactory;
import models.PackageOffer;
import models.Reservation;
import models.memento.ReservationMemento;
import models.payment.PaymentStrategy;
import services.ReservationService;

import java.util.Optional;

public class MainController {

    PackageOfferController packageOfferController;
    CustomTripController customTripController;
    TripServiceController tripServiceController;
    PaymentMethodController paymentMethodController;
    TripSummaryController tripSummaryController;
    CustomerController customerController;
    ReservationService reservationService;
    AgencyController agencyController;

    ReservationManager reservationManager;
    PaymentManager paymentManager;

    public void setDependencies(CustomerController customerController, PackageOfferController packageOfferController,
                                CustomTripController customTripController, PaymentMethodController paymentMethodController,
                                TripServiceController tripServiceController, AgencyController agencyController,
                                TripSummaryController tripSummaryController, ReservationManager reservationManager,
                                PaymentManager paymentManager, ReservationService reservationService) {

        this.packageOfferController = packageOfferController;
        this.customTripController = customTripController;
        this.tripServiceController = tripServiceController;
        this.paymentMethodController = paymentMethodController;
        this.tripSummaryController = tripSummaryController;
        this.customerController = customerController;
        this.reservationService = reservationService;
        this.agencyController = agencyController;
        this.reservationManager = reservationManager;
        this.paymentManager = paymentManager;

    }

    public void enableOfferPanelFields(boolean isEnabled) {
        packageOfferController.setAllFieldsEnabled(isEnabled);
    }

    public void enableIndividualPanelFields(boolean isEnabled) {
        customTripController.setAllFieldsEnabled(isEnabled);
    }

    public void enablePaymentMethodPanelFields(boolean isEnabled) {
        paymentMethodController.setAllFieldsEnabled(isEnabled);
    }

    public void clearIndividualPanelSelection() {
        customTripController.clearFields();
    }

    public void clearOfferPanelSelection() {
        packageOfferController.clearFields();
    }

    public void clearServicePanelTextArea() {
        tripServiceController.clearFields();
    }

    public void clearPaymentPanelTextArea() {
        paymentMethodController.clearTextArea();
    }

    public void displayReservationInDetailsPanel(Reservation reservation) {
        tripSummaryController.setReservationDetails(reservation);
    }

    public void displayTransDetailsInServicePanel(String transDetails) {
        tripServiceController.displayTransDetails(transDetails);
    }

    public void displayAccDetailsInServicePanel(String accDetails) {
        tripServiceController.displayAccommodationDetails(accDetails);
    }

    public void displayActivityDetailsInServicePanel(String activityDetails) {
        tripServiceController.displayActivityDetails(activityDetails);
    }

    public void displayServiceDetailsInServicePanel(PackageOffer packageOffer) {
        tripServiceController.displayServiceDetails(packageOffer);
    }

    public void displayDiscountedPriceInPaymentPanel(int totalPrice) {
        paymentMethodController.displayTotalPriceWithDiscount(totalPrice);
    }

    public void displayPackagePriceInPaymentPanel(int totalPrice) {
        paymentMethodController.displayTotalPackagePrice(totalPrice);
    }

    public Optional<ReservationMemento> handleSearchReservationByMobileNumber(String mobileNumber) {
        return reservationService.findReservationByMobileNumber(mobileNumber);
    }

    public ReservationMemento handleMakeReservation() {
        return reservationManager.getReservationMemento();
    }

    public void handleConfirmReservation() {
        PaymentDialogFactory.displayPaymentDialog(paymentMethodController.getPaymentMethodSelection());
    }

    public void handlePaymentDenial() {
        agencyController.configureButtonsAfterPaymentFailure();
    }

    public void handlePaymentProcessing() {
        paymentManager.processPayment();
    }

    public void clearAllSelectionsInPanels() {
        customerController.clearFields();
        packageOfferController.clearFields();
        customTripController.clearFields();
        paymentMethodController.clearFields();
        tripServiceController.clearFields();
        agencyController.clearFields();
        tripSummaryController.clearFields();
    }

    public void enablePanelComponents(boolean isEnabled) {
        customerController.setAllFieldsEnabled(isEnabled);
        packageOfferController.setAllFieldsEnabled(isEnabled);
        customTripController.setAllFieldsEnabled(isEnabled);
        paymentMethodController.setAllFieldsEnabled(isEnabled);
        agencyController.toggleReservationComponents(isEnabled);
    }

    public int getDiscountedPrice(int totalPrice) {
        return customerController.calculateDiscountedPrice(totalPrice);
    }

    public boolean isFormComplete() {
        return customerController.areAllRequiredFieldsProvided() &&
                packageOfferController.areAllRequiredFieldsProvided() &&
                customTripController.areAllRequiredFieldsProvided() &&
                paymentMethodController.areAllRequiredFieldsProvided();
    }

    public boolean isIndividualSelected() {
        return customerController.isIndividualSelected();
    }

    public void initializeFactory() {
        PaymentDialogFactory.initialize(this);
    }

    public boolean confirmPaymentAuthorization(PaymentStrategy paymentStrategy) {
        return paymentManager.isAuthorized(paymentStrategy);
    }

    public void enableConfirmButtonInAgencyPanel(boolean isEnabled){
        agencyController.enableConfirmButton(isEnabled);
    }
}
