package models.memento;

import models.Reservation;

import java.io.Serializable;
import java.time.Instant;

public class ReservationMemento implements Serializable {

    private final Reservation reservation;
    private String token;

    public ReservationMemento(Reservation reservation) {
        this.reservation = reservation;
        setToken();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public String getToken() {
        return token;
    }

    private void setToken() {
        this.token = tokenGenerator();
    }

    private String tokenGenerator() {
        return reservation.getCustomer().getPhone() + "_" + Instant.now().toEpochMilli();
    }

    @Override
    public String toString() {
        return "ReservationMemento{" +
                "reservation=" + reservation +
                ", token='" + token + '\'' +
                '}';
    }
}
