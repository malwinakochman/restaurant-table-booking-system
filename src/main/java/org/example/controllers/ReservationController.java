package org.example.controllers;

import org.example.models.Customer;
import org.example.models.Reservation;
import org.example.models.TableModel;
import org.example.requests.ReservationRequest;
import org.example.services.BillService;
import org.example.services.CustomerService;
import org.example.services.ReservationService;
import org.example.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Marking this class as a REST controller and defining the base URL for all the endpoints within.
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    private TableService tableService;
    private BillService billService;
    private CustomerService customerService;

    public ReservationController(ReservationService reservationService, TableService tableService, BillService billService, CustomerService customerService) {
        this.reservationService = reservationService;
        this.tableService = tableService;
        this.billService = billService;
        this.customerService = customerService;
    }

    // Endpoint for retrieving all reservations.
    @GetMapping("all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    // Endpoint for adding a new reservation, with the details provided in the request body.
    @PostMapping("add")
    public ResponseEntity<Reservation> addReservation(@RequestBody ReservationRequest reservationRequest) {
        Reservation newReservation = new Reservation();
        Customer customer = customerService.getCustomer(reservationRequest.getCustomerId());
        newReservation.setCustomer(customer);
        newReservation.setDate(reservationRequest.getDate());
        TableModel table = tableService.getTable(reservationRequest.getTableId());
        newReservation.setTable(table);
        reservationService.saveReservation(newReservation);
        return ResponseEntity.ok(newReservation);
    }
}
