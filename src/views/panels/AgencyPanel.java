package views.panels;

import utility.Utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class AgencyPanel extends JPanel {

    public static final String AGENCY_CONTROL_PANEL_TITLE = "Agency Control Panel";
    public static final String START_LIVE_CHAT_BUTTON = "Start Live Chat";
    public static final String MAKE_RESERVATION_BUTTON = "Make Reservation";
    public static final String SEARCH_CUSTOMER_BY_PHONE_LABEL = "Search Customer by Phone";
    public static final String SEARCH_CUSTOMER_BUTTON = "Search Customer";
    public static final String CONFIRM_PAYMENT_BUTTON = "Confirm Payment";
    public static final String CLEAR_BUTTON = "Clear";
    JButton chatBTN;
    JButton makeReservationBTN;
    JLabel searchLBL;
    JTextField searchFieldArea;
    JButton makeSearchBTN;
    JButton confirmBTN;
    JButton clearBTN;

    public AgencyPanel() {

        TitledBorder titledBorder6 = Utils.createBorder(AGENCY_CONTROL_PANEL_TITLE);
        setBorder(titledBorder6);

        chatBTN = new JButton(START_LIVE_CHAT_BUTTON);
        makeReservationBTN = new JButton(MAKE_RESERVATION_BUTTON);
        searchLBL = new JLabel(SEARCH_CUSTOMER_BY_PHONE_LABEL);
        searchFieldArea = new JTextField();
        makeSearchBTN = new JButton(SEARCH_CUSTOMER_BUTTON);
        confirmBTN = new JButton(CONFIRM_PAYMENT_BUTTON);
        clearBTN = new JButton(CLEAR_BUTTON);

        add(chatBTN);
        add(makeReservationBTN);
        add(searchLBL);
        add(searchFieldArea);
        add(makeSearchBTN);
        add(new JLabel());
        add(confirmBTN);
        add(clearBTN);

        confirmBTN.setEnabled(false);

        setBounds(660, 15, 300, 300);
        setLayout(new GridLayout(10, 1));
    }

    public JButton getConfirmBTN() {
        return confirmBTN;
    }

    public JButton getClearBTN() {
        return clearBTN;
    }

    public JButton getMakeReservationBTN() {
        return makeReservationBTN;
    }

    public JButton getMakeSearchBTN() {
        return makeSearchBTN;
    }

    public JTextField getSearchFieldArea() {
        return searchFieldArea;
    }
}
