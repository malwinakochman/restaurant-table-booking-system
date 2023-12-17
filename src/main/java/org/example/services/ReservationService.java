package org.example.services;

import org.example.models.Reservation;
import org.example.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;


    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservation(Integer id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
