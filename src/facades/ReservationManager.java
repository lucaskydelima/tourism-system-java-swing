package facades;

import controllers.CustomTripController;
import controllers.CustomerController;
import controllers.PackageOfferController;
import controllers.PaymentMethodController;
import enums.ServiceType;
import models.Customer;
import models.Reservation;
import models.abstracts.Service;
import models.memento.CareTaker;
import models.memento.Originator;
import models.memento.ReservationMemento;
import models.payment.PaymentStrategy;
import repositories.ReservationRepository;

import java.util.HashMap;

public class ReservationManager {

    private final Reservation reservation;
    CustomerController customerController;
    CustomTripController customTripController;
    PackageOfferController packageOfferController;
    PaymentMethodController paymentMethodController;

    ReservationRepository reservationRepository;
    Originator originator;
    CareTaker careTaker;

    public ReservationManager() {
        this.reservation = new Reservation();
    }

    public void setControllers(CustomerController customerController,
                               PackageOfferController packageOfferController,
                               CustomTripController customTripController,
                               PaymentMethodController paymentMethodController,
                               ReservationRepository reservationRepository,
                               Originator originator, CareTaker careTaker) {
        this.customerController = customerController;
        this.customTripController = customTripController;
        this.packageOfferController = packageOfferController;
        this.paymentMethodController = paymentMethodController;
        this.reservationRepository = reservationRepository;
        this.originator = originator;
        this.careTaker = careTaker;
    }

    private void initializeReservationMemento() {
        setupReservation();
        setupObservers();
    }

    public ReservationMemento getReservationMemento() {
        initializeReservationMemento();
        return originator.createMemento(reservation, careTaker);
    }

    private void setupObservers() {
        careTaker.addObserver(reservationRepository);
    }


    private void setupReservation() {
        reservation.setCustomer(buildCustomer());
        reservation.setServices(buildServices());
        reservation.setPaymentStrategy(buildPaymentStrategy());
    }

    private Customer buildCustomer() {
        return customerController.createCustomer();
    }

    private HashMap<ServiceType, Service> buildServices() {
        return customerController.isIndividualSelected() ?
                customTripController.getChosenServices() :
                packageOfferController.getChosenServices();
    }

    private PaymentStrategy buildPaymentStrategy() {
        return paymentMethodController.createPaymentStrategyFromSelection();
    }
}