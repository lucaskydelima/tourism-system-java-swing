package services;

import models.memento.ReservationMemento;
import repositories.ReservationRepository;

import java.util.Optional;

public class ReservationService {

    ReservationRepository reservationRepository;

    public void setDependencies(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<ReservationMemento> findReservationByMobileNumber(String mobileNumber) {
        return reservationRepository.findByMobileNumber(mobileNumber);
    }
}
