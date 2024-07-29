package controllers;

import factories.DiscountFactory;
import models.Customer;
import models.discount.DiscountStrategy;
import views.panels.CustomerPanel;

import javax.swing.*;
import java.util.Objects;
import java.util.stream.Stream;

public class CustomerController {

    public static final String EMPTY_STRING = "";
    CustomerPanel customerPanel;
    MainController mainController;

    public void setDependencies(CustomerPanel customerPanel, MainController mainController) {
        this.customerPanel = customerPanel;
        this.mainController = mainController;

    }

    public void initController() {
        customerPanel.getIsIndividual().addActionListener(e -> handleIndividualSelection());
        customerPanel.getIsGroup().addActionListener(e -> handleGroupSelection());

    }

    private void handleIndividualSelection() {
        mainController.enableOfferPanelFields(false);
        mainController.enableIndividualPanelFields(true);
        mainController.clearServicePanelTextArea();
        mainController.clearOfferPanelSelection();
        mainController.clearPaymentPanelTextArea();
    }

    private void handleGroupSelection() {
        mainController.enableOfferPanelFields(true);
        mainController.enableIndividualPanelFields(false);
        mainController.clearServicePanelTextArea();
        mainController.clearIndividualPanelSelection();
    }

    public Customer createCustomer() {

        return new Customer(
                customerPanel.getCusName().getText(),
                customerPanel.getCusPhone().getText(),
                customerPanel.getCusAge().getText(),
                Objects.requireNonNull(customerPanel.getComboBox().getSelectedItem()).toString(),
                customerPanel.getIsIndividual().isSelected()
        );
    }

    public boolean isIndividualSelected() {
        return customerPanel.getIsIndividual().isSelected();
    }

    public void clearFields() {
        customerPanel.getCusName().setText(EMPTY_STRING);
        customerPanel.getCusPhone().setText(EMPTY_STRING);
        customerPanel.getCusAge().setText(EMPTY_STRING);
        customerPanel.getComboBox().setSelectedItem(EMPTY_STRING);
        customerPanel.getGO().clearSelection();
    }

    public void setAllFieldsEnabled(boolean isEnabled) {
        customerPanel.getCusName().setEnabled(isEnabled);
        customerPanel.getCusPhone().setEnabled(isEnabled);
        customerPanel.getCusAge().setEnabled(isEnabled);

        customerPanel.getIsIndividual().setEnabled(isEnabled);
        customerPanel.getIsGroup().setEnabled(isEnabled);
        customerPanel.getComboBox().setEnabled(isEnabled);
    }

    public boolean areAllRequiredFieldsProvided() {

        return  areFieldsCompleted() &&
                isComboBoxSelected() &&
                isRadioButtonSelected();
    }

    private boolean areFieldsCompleted() {
        return Stream.of(
                customerPanel.getCusName(),
                customerPanel.getCusPhone(),
                customerPanel.getCusAge()
        ).noneMatch(jTextField -> jTextField.getText().isEmpty());
    }

    private boolean isComboBoxSelected() {
        return Stream.of(customerPanel.getComboBox())
                .filter(JComboBox::isEnabled)
                .noneMatch(comboBox -> Objects.equals(comboBox.getSelectedItem(), EMPTY_STRING));
    }

    private boolean isRadioButtonSelected() {

        return Stream.of(customerPanel.getIsIndividual(), customerPanel.getIsGroup())
                .anyMatch(radioButton -> !radioButton.isEnabled() || radioButton.isSelected());
    }

    public int calculateDiscountedPrice(int totalPrice) {
        DiscountStrategy discount = DiscountFactory.createDiscount(Objects.requireNonNull(customerPanel.getComboBox().getSelectedItem()).toString());
        return discount.applyDiscount(totalPrice);
    }
}
