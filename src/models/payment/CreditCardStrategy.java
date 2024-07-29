package models.payment;

import enums.PaymentType;

import java.io.Serializable;

public class CreditCardStrategy implements PaymentStrategy, Serializable {

    private String name;
    private String cvc;
    private String number;
    private String expirationDate;

    public CreditCardStrategy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void pay(int amount) {

    }

    @Override
    public String toString() {
        return PaymentType.CREDIT_CARD.toString();
    }
}
