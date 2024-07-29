package views.panels;

import utility.Utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Optional;

public class CustomTripPanel extends JPanel {
    public static final String INDIVIDUAL_TRIPS_TITLE = "Individual Trips";
    public static final String TRANSPORTATION_LABEL = "Transportation";
    public static final String ACCOMMODATION_LABEL = "Accommodation";
    public static final String ACTIVITY_LABEL = "Activity";
    public static final String[] TRANSPORTATION_OPTIONS = {"", "Taxi", "Bus"};
    public static final String[] ACTIVITY_OPTIONS = {"", "Sea Cruise", "Sky Diving"};
    public static final String[] ACCOMMODATION_OPTIONS = {"", "Hotel", "Motel"};
    JComboBox<String> comboBox1;
    JComboBox<String> comboBox2;
    JComboBox<String> comboBox3;
    JLabel transLBL;
    JLabel activityLBL;
    JLabel accommodationLBL;

    public CustomTripPanel() {

        TitledBorder titledBorder3 = Utils.createBorder(INDIVIDUAL_TRIPS_TITLE);
        setBorder(titledBorder3);

        transLBL = new JLabel(TRANSPORTATION_LABEL);
        accommodationLBL = new JLabel(ACCOMMODATION_LABEL);
        activityLBL = new JLabel(ACTIVITY_LABEL);

        comboBox1 = new JComboBox<>(TRANSPORTATION_OPTIONS);
        comboBox1.setBounds(120, 10, 80, 20);

        add(transLBL);
        add(comboBox1);

        comboBox2 = new JComboBox<>(ACTIVITY_OPTIONS);
        comboBox2.setBounds(120, 10, 80, 20);

        add(activityLBL);
        add(comboBox2);

        comboBox3 = new JComboBox<>(ACCOMMODATION_OPTIONS);
        comboBox3.setBounds(120, 10, 80, 20);

        add(accommodationLBL);
        add(comboBox3);

        comboBox1.setSelectedItem(Optional.empty());
        comboBox2.setSelectedItem(Optional.empty());
        comboBox3.setSelectedItem(Optional.empty());

        setBounds(15, 500, 300, 150);
        setLayout(new GridLayout(3, 2));
    }

    public JComboBox<String> getComboBox1() {
        return comboBox1;
    }

    public JComboBox<String> getComboBox2() {
        return comboBox2;
    }

    public JComboBox<String> getComboBox3() {
        return comboBox3;
    }
}
