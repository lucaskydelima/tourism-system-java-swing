package controllers;

import models.PackageOffer;
import views.panels.TripServicePanel;

public class TripServiceController {
    public static final String EMPTY_STRING = "";
    public static final String ACCOMMODATION_LABEL = "Accommodation: ";
    public static final String ACTIVITY_LABEL = "Activity: ";
    public static final String TRANSPORTATION_LABEL = "Transportation: ";
    TripServicePanel tripServicePanel;
    MainController mainController;

    public void setDependencies(TripServicePanel tripServicePanel, MainController mainController) {
        this.tripServicePanel = tripServicePanel;
        this.mainController = mainController;
    }

    public void clearFields() {
        tripServicePanel.getDetailActivityArea().setText(EMPTY_STRING);
        tripServicePanel.getDetailTransArea().setText(EMPTY_STRING);
        tripServicePanel.getDetailAccommodationArea().setText(EMPTY_STRING);
    }


    public void displayServiceDetails(PackageOffer packageOffer) {
        tripServicePanel.getDetailAccommodationArea().setText(ACCOMMODATION_LABEL + packageOffer.getAccommodation());
        tripServicePanel.getDetailActivityArea().setText(ACTIVITY_LABEL + packageOffer.getActivity());
        tripServicePanel.getDetailTransArea().setText(TRANSPORTATION_LABEL + packageOffer.getTransportation());
    }

    public void displayTransDetails(String transDetails) {
        tripServicePanel.getDetailTransArea().setText(transDetails);
    }

    public void displayAccommodationDetails(String accDetails) {
        tripServicePanel.getDetailAccommodationArea().setText(accDetails);
    }

    public void displayActivityDetails(String activityDetails) {
        tripServicePanel.getDetailActivityArea().setText(activityDetails);
    }
}
