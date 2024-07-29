package models.payment;

import enums.PaymentType;

import java.io.Serializable;

public class PayPalStrategy implements PaymentStrategy, Serializable {

    private String email;
    private char[] password;

    public PayPalStrategy() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public void pay(int amount) {

    }

    @Override
    public String toString() {
        return PaymentType.PAY_PAL.toString();
    }
}
