package models.memento;

import models.Reservation;

public class Originator {

    private ReservationMemento memento;

    public ReservationMemento createMemento(Reservation reservation, CareTaker careTaker) {
        memento = new ReservationMemento(reservation);
        System.out.println(memento);
        notifyCaretaker(careTaker);
        return memento;
    }

    public void restoreFromMemento(ReservationMemento memento) {
        this.memento = memento;
    }

    private void notifyCaretaker(CareTaker careTaker) {
        careTaker.addMemento(memento);
    }
}
