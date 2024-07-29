package views.dialogs;

import javax.swing.*;
import java.awt.*;

public class PayPalDialog extends JDialog implements PaymentDialog {
    private static final String DIALOG_TITLE = "PayPal Payment Confirmation";
    private static final String EMAIL_LABEL = "E-mail";
    private static final String PASSWORD_LABEL = "Password";
    private static final String SUBMIT_LABEL = "Submit";

    JLabel emailLBL;
    JLabel passwordLBL;
    JTextField email;
    JPasswordField password;
    JButton submitBTN;


    public PayPalDialog(JFrame parent) {

        super(parent, DIALOG_TITLE, true);
        emailLBL = new JLabel(EMAIL_LABEL);
        passwordLBL = new JLabel(PASSWORD_LABEL);

        email = new JTextField(20);
        password = new JPasswordField(15);

        email.setOpaque(false);
        password.setOpaque(false);

        submitBTN = new JButton(SUBMIT_LABEL);

        add(emailLBL);
        add(email);
        add(passwordLBL);
        add(password);
        add(new JLabel());
        add(submitBTN);

        setBounds(0, 0, 400, 150);
        setLayout(new GridLayout(4, 2));
        setLocationRelativeTo(getParent());
    }

    @Override
    public void showDialog(boolean isVisible) {
        setVisible(isVisible);
    }

    @Override
    public void closeDialog(){ dispose();}

    public JTextField getEmail() {
        return email;
    }

    public JPasswordField getPasswordField() {
        return password;
    }

    public JButton getSubmitBTN() {
        return submitBTN;
    }

}
