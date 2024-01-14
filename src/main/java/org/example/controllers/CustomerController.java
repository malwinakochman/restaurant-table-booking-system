package org.example.controllers;

import org.example.models.Customer;
import org.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Marking this class as a REST controller and defining the base URL for all the endpoints within.
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // This endpoint method will return a list of all customers when accessed via a GET request.
    @GetMapping("all")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }
}
