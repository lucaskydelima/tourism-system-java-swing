package views.panels;

import enums.PackageType;
import utility.Utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PackageOfferPanel extends JPanel {

    public static final String SPECIAL_OFFERS_TITLE = "Special Offers";
    public static final String PACKAGE_1_LABEL = "Package 1";
    public static final String PACKAGE_2_LABEL = "Package 2";
    public static final String PACKAGE_3_LABEL = "Package 3";
    JRadioButton package1RadioBTN;
    JRadioButton package2RadioBTN;
    JRadioButton package3RadioBTN;
    ButtonGroup G1;

    public PackageOfferPanel() {

        TitledBorder titledBorder2 = Utils.createBorder(SPECIAL_OFFERS_TITLE);
        setBorder(titledBorder2);

        package1RadioBTN = new JRadioButton(PACKAGE_1_LABEL);
        package2RadioBTN = new JRadioButton(PACKAGE_2_LABEL);
        package3RadioBTN = new JRadioButton(PACKAGE_3_LABEL);

        package1RadioBTN.setActionCommand(PackageType.PACK_1.toString());
        package2RadioBTN.setActionCommand(PackageType.PACK_2.toString());
        package3RadioBTN.setActionCommand(PackageType.PACK_3.toString());

        G1 = new ButtonGroup();
        G1.add(package1RadioBTN);
        G1.add(package2RadioBTN);
        G1.add(package3RadioBTN);

        add(package1RadioBTN);
        add(package2RadioBTN);
        add(package3RadioBTN);

        setBounds(15, 250, 300, 200);
        setLayout(new GridLayout(3, 1));
    }

    public JRadioButton getPackage1RadioBTN() {
        return package1RadioBTN;
    }

    public JRadioButton getPackage2RadioBTN() {
        return package2RadioBTN;
    }

    public JRadioButton getPackage3RadioBTN() {
        return package3RadioBTN;
    }

    public ButtonGroup getG1() {
        return G1;
    }
}
