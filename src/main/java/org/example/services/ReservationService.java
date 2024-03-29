package org.example.services;

import org.example.models.Reservation;
import org.example.models.TableModel;
import org.example.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Reservation> getByDate(LocalDate date) {
            return reservationRepository.findAll().stream()
                    .filter(reservation -> reservation.getDate().toLocalDate().equals(date))
                    .collect(Collectors.toList());
    }

    public List<TableModel> getAllReservedTables(LocalDateTime date) {
        return reservationRepository.findReservedTablesByDate(date);
    }


}
