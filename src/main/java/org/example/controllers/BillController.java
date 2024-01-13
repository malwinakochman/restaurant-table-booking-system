package org.example.controllers;

import org.example.models.Bill;
import org.example.requests.BillRequest;
import org.example.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
@CrossOrigin(origins = "http://localhost:8080")  // Dostosuj do adresu frontendu
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("all")
    public List<Bill> getAllBills() {
        return billService.getAll();
    }

    @PostMapping("/add")
    public Bill addBill(@RequestBody BillRequest billRequest) {
        Bill newBill = new Bill();
        newBill.setBillPrice(billRequest.getBillPrice());
        newBill.setIsPayed(billRequest.getIsPayed());
        newBill.setListOfDishes(billRequest.getListOfDishes());
        billService.saveBill(newBill);
        return newBill;
    }

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
                existingBill.setListOfDishes(billRequest.getListOfDishes());
            }
            billService.saveBill(existingBill);
            return ResponseEntity.ok(existingBill);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Rachunek o ID " + billId + " nie został znaleziony.");
        }
    }

}
