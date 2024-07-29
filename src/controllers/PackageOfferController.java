package controllers;

import builders.Offer1Builder;
import builders.Offer2Builder;
import builders.Offer3Builder;
import enums.ServiceType;
import factories.PackageFactory;
import models.PackageOffer;
import models.abstracts.Service;
import views.panels.PackageOfferPanel;

import java.util.HashMap;
import java.util.stream.Stream;

public class PackageOfferController {

    PackageOfferPanel packageOfferPanel;
    MainController mainController;

    public void setDependencies(PackageOfferPanel packageOfferPanel, MainController mainController) {
        this.packageOfferPanel = packageOfferPanel;
        this.mainController = mainController;
    }

    public void initController() {
        packageOfferPanel.getPackage1RadioBTN().addActionListener(e -> handlePackage1RadioSelection());
        packageOfferPanel.getPackage2RadioBTN().addActionListener(e -> handlePackage2RadioSelection());
        packageOfferPanel.getPackage3RadioBTN().addActionListener(e -> handlePackage3RadioSelection());
    }

    public void handlePackage1RadioSelection() {
        PackageOffer packageOffer1 = new Offer1Builder().createPackage();
        mainController.displayServiceDetailsInServicePanel(packageOffer1);
        mainController.displayPackagePriceInPaymentPanel(packageOffer1.getPackagePrice());
    }

    public void handlePackage2RadioSelection() {
        PackageOffer packageOffer2 = new Offer2Builder().createPackage();
        mainController.displayServiceDetailsInServicePanel(packageOffer2);
        mainController.displayPackagePriceInPaymentPanel(packageOffer2.getPackagePrice());
    }

    public void handlePackage3RadioSelection() {
        PackageOffer packageOffer3 = new Offer3Builder().createPackage();
        mainController.displayServiceDetailsInServicePanel(packageOffer3);
        mainController.displayPackagePriceInPaymentPanel(packageOffer3.getPackagePrice());
    }

    public void setAllFieldsEnabled(boolean isEnabled) {
        packageOfferPanel.getPackage1RadioBTN().setEnabled(isEnabled);
        packageOfferPanel.getPackage2RadioBTN().setEnabled(isEnabled);
        packageOfferPanel.getPackage3RadioBTN().setEnabled(isEnabled);
    }

    public void clearFields() {
        packageOfferPanel.getG1().clearSelection();
    }

    public HashMap<ServiceType, Service> getChosenServices() {

        PackageOffer packageOffer = PackageFactory.createPackage(packageOfferPanel.getG1().getSelection().getActionCommand());

        HashMap<ServiceType, Service> services = new HashMap<>();
        services.put(ServiceType.TRANSPORTATION, packageOffer.getTransportation());
        services.put(ServiceType.ACTIVITY, packageOffer.getActivity());
        services.put(ServiceType.ACCOMMODATION, packageOffer.getAccommodation());

        return services;
    }

    public boolean areAllRequiredFieldsProvided() {
        return Stream.of(
                        packageOfferPanel.getPackage1RadioBTN(),
                        packageOfferPanel.getPackage2RadioBTN(),
                        packageOfferPanel.getPackage3RadioBTN()
                )
                .anyMatch(radioButton ->
                        !radioButton.isEnabled() || radioButton.isSelected()
                );
    }
}
