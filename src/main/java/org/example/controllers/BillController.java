package org.example.controllers;

import org.example.models.Bill;
import org.example.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("all")
    public List<Bill> getAllBills() {
        return billService.getAll();
    }

}
