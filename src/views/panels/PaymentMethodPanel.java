package views.panels;

import enums.PaymentType;
import utility.Utils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PaymentMethodPanel extends JPanel {
    public static final String PAYMENT_METHODS_TITLE = "Payment Methods";
    public static final String TOTAL_PRICE_TEXT = "Total Price: USD";
    public static final String PAYPAL_LABEL = "PayPal";
    public static final String CREDIT_CARD_LABEL = "Credit Card";

    public static final String FONT_NAME = "SansSerif";
    public static final int FONT_STYLE = Font.BOLD;
    public static final int FONT_SIZE = 16;
    JRadioButton payment1RadioBTN;
    JRadioButton payment2RadioBTN;
    JTextArea totalPriceArea;
    ButtonGroup G2;


    public PaymentMethodPanel() {

        TitledBorder titledBorder4 = Utils.createBorder(PAYMENT_METHODS_TITLE);
        setBorder(titledBorder4);

        totalPriceArea = new JTextArea(TOTAL_PRICE_TEXT);
        totalPriceArea.setOpaque(false);
        totalPriceArea.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));

        payment1RadioBTN = new JRadioButton(PAYPAL_LABEL);
        payment2RadioBTN = new JRadioButton(CREDIT_CARD_LABEL);

        payment1RadioBTN.setActionCommand(PaymentType.PAY_PAL.toString());
        payment2RadioBTN.setActionCommand(PaymentType.CREDIT_CARD.toString());

        G2 = new ButtonGroup();
        G2.add(payment1RadioBTN);
        G2.add(payment2RadioBTN);

        add(payment1RadioBTN);
        add(payment2RadioBTN);
        add(totalPriceArea);

        setBounds(330, 15, 300, 400);
        setLayout(new GridLayout(3, 1));
    }

    public JRadioButton getPayment1RadioBTN() {
        return payment1RadioBTN;
    }

    public JRadioButton getPayment2RadioBTN() {
        return payment2RadioBTN;
    }

    public JTextArea getTotalPriceArea() {
        return totalPriceArea;
    }

    public ButtonGroup getG2() {
        return G2;
    }
}
