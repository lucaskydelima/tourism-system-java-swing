package views.panels;

import utility.Utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TripSummaryPanel extends JPanel {
    public static final String RESERVATION_DETAILS_TITLE = " Reservation Details";
    public static final String FONT_NAME = "SansSerif";
    public static final int FONT_STYLE = Font.BOLD;
    public static final int FONT_SIZE = 16;
    JTextArea reservationDetailsArea;

    public TripSummaryPanel() {

        TitledBorder titledBorder7 = Utils.createBorder(RESERVATION_DETAILS_TITLE);
        setBorder(titledBorder7);

        reservationDetailsArea = new JTextArea();
        reservationDetailsArea.setOpaque(false);
        reservationDetailsArea.setEnabled(false);
        reservationDetailsArea.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));

        JScrollPane scrollPane = new JScrollPane(reservationDetailsArea);

        add(scrollPane);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setBounds(660, 330, 300, 300);
        setLayout(new GridLayout(1, 1));
    }

    public JTextArea getReservationDetailsArea() {
        return reservationDetailsArea;
    }
}
