package views.panels;

import utility.Utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CustomerPanel extends JPanel {

    public static final String CUSTOMER_PANEL_TITLE = "Customer";
    public static final String CUSTOMER_NAME_LABEL = " Name";
    public static final String CUSTOMER_PHONE_LABEL = " Phone";
    public static final String CUSTOMER_AGE_LABEL = " Age";
    public static final String CUSTOMER_JOB_LABEL = " Job";
    public static final String[] JOB_OPTIONS = {"", "Student", "Business", "Retired", "Employee"};
    public static final String INDIVIDUAL_RADIO_BUTTON = "Individual";
    public static final String GROUP_RADIO_BUTTON = "Group";
    JTextField cusName, cusPhone, cusAge;
    JRadioButton isIndividual, isGroup;
    ButtonGroup GO;
    JComboBox<String> comboBox;

    public CustomerPanel() {

        TitledBorder titledBorder = Utils.createBorder(CUSTOMER_PANEL_TITLE);

        setBorder(titledBorder);

        JLabel fNameLBL = new JLabel(CUSTOMER_NAME_LABEL);
        JLabel phoneLBL = new JLabel(CUSTOMER_PHONE_LABEL);
        JLabel ageLBL = new JLabel(CUSTOMER_AGE_LABEL);
        JLabel jobLBL = new JLabel(CUSTOMER_JOB_LABEL);

        cusName = new JTextField();
        cusPhone = new JTextField();
        cusAge = new JTextField();

        comboBox = new JComboBox<>(JOB_OPTIONS);
        isIndividual = new JRadioButton(INDIVIDUAL_RADIO_BUTTON);
        isGroup = new JRadioButton(GROUP_RADIO_BUTTON);
        GO = new ButtonGroup();

        cusName.setOpaque(false);
        cusAge.setOpaque(false);
        cusPhone.setOpaque(false);

        comboBox.setBounds(120, 10, 80, 20);

        add(fNameLBL);
        add(cusName);
        add(phoneLBL);
        add(cusPhone);
        add(ageLBL);
        add(cusAge);
        add(jobLBL);
        add(comboBox);
        add(isIndividual);
        add(isGroup);

        GO.add(isIndividual);
        GO.add(isGroup);

        comboBox.setSelectedItem(null);
        setBounds(15, 15, 300, 200);
        setLayout(new GridLayout(5, 2));
    }

    public JTextField getCusName() {
        return cusName;
    }

    public JTextField getCusPhone() {
        return cusPhone;
    }

    public JTextField getCusAge() {
        return cusAge;
    }

    public JRadioButton getIsIndividual() {
        return isIndividual;
    }

    public JRadioButton getIsGroup() {
        return isGroup;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public ButtonGroup getGO() {
        return GO;
    }
}
