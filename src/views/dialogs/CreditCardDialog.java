package views.dialogs;

import javax.swing.*;
import java.awt.*;

public class CreditCardDialog extends JDialog implements PaymentDialog {
    private static final String DIALOG_TITLE = "Credit Card Confirmation";
    private static final String NAME_LABEL = "Cardholder Name";
    private static final String CODE_LABEL = "CVC code";
    private static final String NUMBER_LABEL = "Card Number";
    private static final String EXPIRATION_DATE_LABEL = "Expiration Date";
    private static final String SUBMIT_LABEL = "Submit";

    JLabel NameLBL;
    JLabel CodeLBL;
    JLabel NumberLBL;
    JLabel ExpirationDateLBL;
    JTextField Name;
    JTextField Code;
    JTextField Number;
    JTextField ExpirationDate;
    JButton SubmitBTN;

    public CreditCardDialog(JFrame parent) {

        super(parent, DIALOG_TITLE, true);
        NameLBL = new JLabel(NAME_LABEL);
        CodeLBL = new JLabel(CODE_LABEL);
        NumberLBL = new JLabel(NUMBER_LABEL);
        ExpirationDateLBL = new JLabel(EXPIRATION_DATE_LABEL);

        Name = new JTextField();
        Name.setOpaque(false);
        Code = new JTextField();
        Code.setOpaque(false);
        Number = new JTextField();
        Number.setOpaque(false);
        ExpirationDate = new JTextField();
        ExpirationDate.setOpaque(false);

        SubmitBTN = new JButton(SUBMIT_LABEL);

        add(NameLBL);
        add(Name);

        add(NumberLBL);
        add(Number);

        add(CodeLBL);
        add(Code);

        add(ExpirationDateLBL);
        add(ExpirationDate);

        add(new JLabel());
        add(SubmitBTN);

        setBounds(0, 0, 500, 250);
        setLayout(new GridLayout(6, 2));
        setLocationRelativeTo(getParent());
    }

    @Override
    public void showDialog(boolean isVisible) {
        setVisible(isVisible);
    }

    @Override
    public void closeDialog() {
        dispose();
    }

    public JTextField getNameOnCard() {
        return Name;
    }

    public JTextField getCode() {
        return Code;
    }

    public JTextField getNumber() {
        return Number;
    }

    public JTextField getExpirationDate() {
        return ExpirationDate;
    }

    public JButton getSubmitBTN() {
        return SubmitBTN;
    }
}
