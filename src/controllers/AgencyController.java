package controllers;

import models.memento.ReservationMemento;
import views.options.Option;
import views.panels.AgencyPanel;

import javax.swing.*;
import java.util.Optional;

public class AgencyController {
    public static final String FIELD_REQUIRED_MESSAGE = "Please fill in all fields to proceed with the reservation.";
    public static final String RESERVATION_STATUS_TITLE = "Reservation Status";
    public static final String PROCEED_TO_PAYMENT_MESSAGE = "Do you want to proceed to payment?";
    public static final String CONFIRMATION_TITLE = "Confirmation";
    public static final String EMPTY_STRING = "";


    AgencyPanel agencyPanel;
    MainController mainController;
    ReservationMemento reservationMemento;

    public void setDependencies(AgencyPanel agencyPanel, MainController mainController) {
        this.agencyPanel = agencyPanel;
        this.mainController = mainController;
    }

    public void initController() {
        agencyPanel.getMakeSearchBTN().addActionListener(e -> handleSearchReservationButtonClick());
        agencyPanel.getMakeReservationBTN().addActionListener(e -> handleMakeReservationButtonClick());
        agencyPanel.getConfirmBTN().addActionListener(e -> handleConfirmReservationButtonClick());
        agencyPanel.getClearBTN().addActionListener(e -> handleClearReservationButtonClick());
    }


    private void handleSearchReservationButtonClick() {
        String mobileNumber = agencyPanel.getSearchFieldArea().getText();
        Optional<ReservationMemento> optionalMemento = mainController.handleSearchReservationByMobileNumber(mobileNumber);
        optionalMemento.ifPresent(memento -> mainController.displayReservationInDetailsPanel(memento.getReservation()));
    }

    private void handleMakeReservationButtonClick() {
        if (isFormComplete()) {
            createReservationMemento();
            prepareAndDisplayReservation();
        } else {
            showErrorForIncompleteForm();
        }
    }

    private void handleConfirmReservationButtonClick() {
        int confirmation = Option.showConfirmDialog(CONFIRMATION_TITLE, PROCEED_TO_PAYMENT_MESSAGE);

        if (confirmation == JOptionPane.YES_OPTION) {
            mainController.handleConfirmReservation();
        }
    }

    private void handleClearReservationButtonClick() {
        mainController.clearAllSelectionsInPanels();
        mainController.enablePanelComponents(true);
    }

    private boolean isFormComplete() {
        return mainController.isFormComplete();
    }

    private void createReservationMemento() {
        this.reservationMemento = mainController.handleMakeReservation();
    }

    private void prepareAndDisplayReservation() {
        disablePanelComponents();
        enableConfirmButton(true);
        displayReservationPrice();
        displayReservationDetails(reservationMemento);
    }

    private void displayReservationPrice() {
        int totalPrice = reservationMemento.getReservation().getTotalPrice();
        if (mainController.isIndividualSelected()) {
            mainController.displayDiscountedPriceInPaymentPanel(totalPrice);
        } else {
            mainController.displayPackagePriceInPaymentPanel(totalPrice);
        }
    }

    private void disablePanelComponents() {
        mainController.enablePanelComponents(false);
    }

    private void displayReservationDetails(ReservationMemento memento) {
        mainController.displayReservationInDetailsPanel(memento.getReservation());
    }

    private void showErrorForIncompleteForm() {
        Option.showErrorMessage(RESERVATION_STATUS_TITLE, FIELD_REQUIRED_MESSAGE);
    }

    public void enableConfirmButton(boolean isEnabled) {
        agencyPanel.getConfirmBTN().setEnabled(isEnabled);
    }

    public void toggleReservationComponents(boolean isEnabled) {
        agencyPanel.getMakeReservationBTN().setEnabled(isEnabled);
        agencyPanel.getMakeSearchBTN().setEnabled(isEnabled);
        agencyPanel.getSearchFieldArea().setEnabled(isEnabled);
    }

    public void configureButtonsAfterPaymentFailure() {
        agencyPanel.getConfirmBTN().setEnabled(false);
        agencyPanel.getMakeReservationBTN().setEnabled(true);
    }

    public void clearFields() {
        agencyPanel.getSearchFieldArea().setText(EMPTY_STRING);
    }
}
