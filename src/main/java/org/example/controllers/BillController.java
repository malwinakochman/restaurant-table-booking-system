package org.example.controllers;

import org.example.models.Bill;
import org.example.models.Dish;
import org.example.requests.BillRequest;
import org.example.services.BillService;
import org.example.services.DishService;
import org.example.services.ReservationService;
import org.example.services.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Marking this class as a REST controller and defining the base URL for all the endpoints within.
@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private WaiterService waiterService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private DishService dishService;

    // Endpoint for retrieving all bills.
    @GetMapping("all")
    public List<Bill> getAllBills() {
        return billService.getAll();
    }

    // Endpoint for adding a new bill, with the details provided in the request body.
    @PostMapping("/add")
    public Bill addBill(@RequestBody BillRequest billRequest) {
        Bill newBill = new Bill();
        newBill.setBillPrice(billRequest.getBillPrice());
        newBill.setIsPayed(billRequest.getIsPayed());
        newBill.setListOfDishes(getDishesAsString(billRequest.getListOfDishes()));
        newBill.setDate(LocalDateTime.now());
        if (billRequest.getReservationId() != null) {
            newBill.setReservation(reservationService.getReservation(billRequest.getReservationId()));
        }
        newBill.setWaiter(waiterService.getWaiter(billRequest.getWaiterId()));
        billService.saveBill(newBill);
        return newBill;
    }

    // Endpoint for editing an existing bill based on the provided bill ID and request body.
    @PutMapping("/edit/{billId}")
    public ResponseEntity<?> editBill(@PathVariable("billId") Integer billId, @RequestBody BillRequest billRequest) {
        Bill existingBill = billService.getBill(billId);
        if (existingBill != null) {
            if (billRequest.getBillPrice() != null) {
                existingBill.setBillPrice(billRequest.getBillPrice());
            }
            if (billRequest.getIsPayed() != null) {
                existingBill.setIsPayed(billRequest.getIsPayed());
            }
            if (billRequest.getListOfDishes() != null) {
                existingBill.setListOfDishes(getDishesAsString(billRequest.getListOfDishes()));
            }
            if (billRequest.getWaiterId() != null) {
                existingBill.setWaiter(waiterService.getWaiter(billRequest.getWaiterId()));
            }
            billService.saveBill(existingBill);
            return ResponseEntity.ok(existingBill);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Rachunek o ID " + billId + " nie został znaleziony.");
        }
    }

    // Endpoint for getting bill by id
    @GetMapping("/{billId}")
    public ResponseEntity<?> getBill(@PathVariable("billId") Integer billId) {
        Bill bill = billService.getBill(billId);
        if (bill != null) {
            BillRequest billRequest = new BillRequest();
            billRequest.setBillId(bill.getBillId());
            billRequest.setBillPrice(bill.getBillPrice());
            billRequest.setIsPayed(bill.getIsPayed());
            billRequest.setListOfDishes(getDishesAsList(bill.getListOfDishes()));
            billRequest.setWaiterId(bill.getWaiter() != null ? bill.getWaiter().getWaiterId() : null);
            billRequest.setReservationId(bill.getReservation() != null ? bill.getReservation().getReservationId() : null);

            return ResponseEntity.ok(billRequest);
        }
        if (bill != null) {
            return ResponseEntity.ok(bill);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Rachunek o ID " + billId + " nie został znaleziony.");
        }
    }

    // Private method to get dishes as string from list.
    private static String getDishesAsString(List<Dish> listOfDishes) {
        String dishes = listOfDishes.stream()
                .map(Dish::getDishName)
                .collect(Collectors.joining(", "));
        return dishes;
    }

    // Private method to get dishes as list from string.
    private List<Dish> getDishesAsList(String listOfDishes) {
        List<String> dishNames = Arrays.asList(listOfDishes.split(",\\s*"));
        return dishNames.stream()
                .map(dishService::getDishByName)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Bill>> getBillsByFilter(
            @RequestParam(name = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(name = "waiterId", required = false) Integer waiterId,
            @RequestParam(name = "isPayed", required = false) Boolean isPayed,
            @RequestParam(name = "reservationId", required = false) Integer reservationId) {

        List<Bill> bills = billService.getBillsByFilter(date, waiterId, isPayed, reservationId);
        if (bills.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bills);
    }

}
