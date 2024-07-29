package models.memento;

import models.observer.Observer;
import models.observer.Subject;

import java.util.ArrayList;
import java.util.TreeMap;

public class CareTaker implements Subject {

    private final TreeMap<String, ReservationMemento> reservationStateMap;
    private final ArrayList<Observer> observers;

    public CareTaker() {
        reservationStateMap = new TreeMap<>();
        observers = new ArrayList<>();
    }

    public void addMemento(ReservationMemento memento) {
        reservationStateMap.put(memento.getToken(), memento);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(reservationStateMap);
        }
    }
}
