package org.example.controllers;

import org.example.models.Customer;
import org.example.requests.CustomerRequest;
import org.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // REST endpoint for adding a new customer based on the provided CustomerRequest data.
    // This endpoint receives a JSON representation of CustomerRequest in the request body.
    @PostMapping("add")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerSurname(customerRequest.getCustomerSurname());
        newCustomer.setPhone(customerRequest.getCustomerPhone());

        Customer savedCustomer = customerService.saveCustomer(newCustomer);

        // Zwróć kod 201 Created i obiekt savedCustomer w ciele odpowiedzi
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }
}