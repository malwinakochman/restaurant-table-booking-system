package org.example.controllers;

import org.example.models.Customer;
import org.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:8080")  // Dostosuj do adresu frontendu
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("all")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }
}
