package models;

import enums.ServiceType;
import models.abstracts.Service;
import models.payment.PaymentStrategy;

import java.io.Serializable;
import java.util.HashMap;

public class Reservation implements Serializable {

    private Customer customer;
    private HashMap<ServiceType, Service> services;
    private PaymentStrategy paymentStrategy;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HashMap<ServiceType, Service> getServices() {
        return services;
    }

    public void setServices(HashMap<ServiceType, Service> services) {
        this.services = services;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public int getTotalPrice() {
        return services.values().stream().mapToInt(Service::getPrice).sum();
    }

    @Override
    public String toString() {
        return customer + "\n " + services.toString() + "\n " + paymentStrategy;
    }
}

