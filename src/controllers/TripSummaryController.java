package controllers;

import models.Reservation;
import views.panels.TripSummaryPanel;

import java.util.Objects;

public class TripSummaryController {

    public static final String CUSTOMER_NOT_FOUND = "Customer not found!";
    public static final String EMPTY_STRING = "";
    TripSummaryPanel tripSummaryPanel;
    MainController mainController;

    public void setDependencies(TripSummaryPanel tripSummaryPanel, MainController mainController) {
        this.tripSummaryPanel = tripSummaryPanel;
        this.mainController = mainController;
    }

    public void setReservationDetails(Reservation reservation) {
        if (Objects.nonNull(reservation))
            tripSummaryPanel.getReservationDetailsArea().setText(reservation.toString());
        else
            tripSummaryPanel.getReservationDetailsArea().setText(CUSTOMER_NOT_FOUND);
    }

    public void clearFields() {
        tripSummaryPanel.getReservationDetailsArea().setText(EMPTY_STRING);
    }
}
