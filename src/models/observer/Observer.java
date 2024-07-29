package models.observer;

import models.memento.ReservationMemento;

import java.util.TreeMap;

public interface Observer {

    void update(TreeMap<String, ReservationMemento> reservations);
}
