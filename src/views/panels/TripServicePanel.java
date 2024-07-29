package views.panels;

import utility.Utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TripServicePanel extends JPanel {
    public static final String SERVICE_DETAILS_TITLE = "Service Details";
    public static final String FONT_NAME = "SansSerif";
    public static final int FONT_STYLE = Font.BOLD;
    public static final int FONT_SIZE = 16;
    JTextArea detailTransArea;
    JTextArea detailActivityArea;
    JTextArea detailAccommodationArea;

    public TripServicePanel() {

        TitledBorder titledBorder5 = Utils.createBorder(SERVICE_DETAILS_TITLE);
        setBorder(titledBorder5);

        detailTransArea = new JTextArea();
        detailActivityArea = new JTextArea();
        detailAccommodationArea = new JTextArea();

        detailTransArea.setOpaque(false);
        detailActivityArea.setOpaque(false);
        detailAccommodationArea.setOpaque(false);

        detailTransArea.setEnabled(false);
        detailActivityArea.setEnabled(false);
        detailAccommodationArea.setEnabled(false);

        detailTransArea.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
        detailActivityArea.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
        detailAccommodationArea.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));

        add(detailTransArea);
        add(detailActivityArea);
        add(detailAccommodationArea);

        setBounds(330, 450, 300, 300);
        setLayout(new GridLayout(3, 1));
    }

    public JTextArea getDetailTransArea() {
        return detailTransArea;
    }

    public JTextArea getDetailActivityArea() {
        return detailActivityArea;
    }

    public JTextArea getDetailAccommodationArea() {
        return detailAccommodationArea;
    }
}
