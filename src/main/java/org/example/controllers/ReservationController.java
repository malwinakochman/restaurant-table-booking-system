package org.example.controllers;

import org.example.models.Reservation;
import org.example.models.TableModel;
import org.example.requests.ReservationRequest;
import org.example.services.BillService;
import org.example.services.ReservationService;
import org.example.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

// Marking this class as a REST controller and defining the base URL for all the endpoints within.
@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationService reservationService;
    private TableService tableService;
    private BillService billService;

    public ReservationController(ReservationService reservationService, TableService tableService, BillService billService) {
        this.reservationService = reservationService;
        this.tableService = tableService;
        this.billService = billService;
    }

    // Endpoint for retrieving all reservations.
    @GetMapping("all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    // Endpoint for adding a new reservation, with the details provided in the request body.
    @PostMapping("add")
    public ResponseEntity<String> addReservation(@RequestBody ReservationRequest reservationRequest) {
        Reservation newReservation = new Reservation();
        newReservation.setDate(reservationRequest.getDate());
        newReservation.setCustomerSurname(reservationRequest.getCustomerSurname());
        newReservation.setCustomerPhone(reservationRequest.getCustomerPhone());
        TableModel table = tableService.getTable(reservationRequest.getTableId());
        newReservation.setTable(table);
        reservationService.saveReservation(newReservation);
        return ResponseEntity.ok(String.valueOf(newReservation));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable(name = "id") Integer id) {
        try {
            Reservation reservation = reservationService.getReservation(id);
            if (reservation == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reservation not found");
            }
            reservationService.deleteReservation(id);
            return ResponseEntity.ok("Reservation deleted");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting reservation");
        }
    }

}
