package controllers;

import enums.ServiceType;
import factories.AccommodationFactory;
import factories.ActivityFactory;
import factories.TransportationFactory;
import models.abstracts.Service;
import views.panels.CustomTripPanel;

import javax.swing.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Stream;

public class CustomTripController {

    public static final String EMPTY_STRING = "";

    CustomTripPanel customTripPanel;

    MainController mainController;

    public void setDependencies(CustomTripPanel customTripPanel, MainController mainController) {
        this.customTripPanel = customTripPanel;
        this.mainController = mainController;

    }

    public void initController() {
        customTripPanel.getComboBox1().addActionListener(e -> handleComboBox1Selection());
        customTripPanel.getComboBox2().addActionListener(e -> handleComboBox2Selection());
        customTripPanel.getComboBox3().addActionListener(e -> handleComboBox3Selection());
    }

    public void handleComboBox1Selection() {
        mainController.displayTransDetailsInServicePanel(
                Objects.requireNonNull(customTripPanel.getComboBox1().getSelectedItem()).toString()
        );
    }

    public void handleComboBox2Selection() {
        mainController.displayActivityDetailsInServicePanel(
                Objects.requireNonNull(customTripPanel.getComboBox2().getSelectedItem()).toString()
        );
    }

    public void handleComboBox3Selection() {
        mainController.displayAccDetailsInServicePanel(
                Objects.requireNonNull(customTripPanel.getComboBox3().getSelectedItem()).toString()
        );
    }

    public void setAllFieldsEnabled(boolean isEnabled) {
        customTripPanel.getComboBox1().setEnabled(isEnabled);
        customTripPanel.getComboBox2().setEnabled(isEnabled);
        customTripPanel.getComboBox3().setEnabled(isEnabled);
    }

    public void clearFields() {
        customTripPanel.getComboBox1().setSelectedItem(EMPTY_STRING);
        customTripPanel.getComboBox2().setSelectedItem(EMPTY_STRING);
        customTripPanel.getComboBox3().setSelectedItem(EMPTY_STRING);
    }

    public HashMap<ServiceType, Service> getChosenServices() {
        HashMap<ServiceType, Service> services = new HashMap<>();
        services.put(ServiceType.TRANSPORTATION, createTransportation());
        services.put(ServiceType.ACTIVITY, createActivity());
        services.put(ServiceType.ACCOMMODATION, createAccommodation());

        return services;
    }

    private Service createTransportation() {
        return TransportationFactory.createTransportation(Objects.requireNonNull(customTripPanel.getComboBox1()
                .getSelectedItem()).toString());
    }

    private Service createActivity() {

        return ActivityFactory.createActivity(Objects.requireNonNull(customTripPanel.getComboBox2()
                .getSelectedItem()).toString());
    }

    private Service createAccommodation() {
        return AccommodationFactory.createAccommodation(Objects.requireNonNull(customTripPanel.getComboBox3()
                .getSelectedItem()).toString());
    }


    public boolean areAllRequiredFieldsProvided() {

        return Stream.of(customTripPanel.getComboBox1(),
                        customTripPanel.getComboBox2(),
                        customTripPanel.getComboBox3())
                .filter(JComboBox::isEnabled)
                .noneMatch(comboBox -> Objects.equals(comboBox.getSelectedItem(), EMPTY_STRING));
    }

}

