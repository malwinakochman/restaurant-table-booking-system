package org.example.controllers;

import org.example.models.Customer;
import org.example.models.Reservation;
import org.example.services.ReservationService;
import org.example.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    private TableService tableService;

    @GetMapping("all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    @PostMapping("/add")
    public Reservation addReservation(Integer hour, Integer tableId, Customer customer,
                                      Integer billId, Date date ) {
        Reservation newReservation = new Reservation();
        newReservation.setCustomer(customer);
        newReservation.setHour(hour);
        newReservation.setDate(date);
        newReservation.setTable(tableService.getTable(tableId));
        reservationService.saveReservation(newReservation);
        return newReservation;
    }
}
