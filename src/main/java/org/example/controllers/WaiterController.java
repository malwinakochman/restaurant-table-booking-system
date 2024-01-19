package org.example.controllers;

import org.example.models.Waiter;
import org.example.requests.WaiterDTO;
import org.example.services.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Marking this class as a REST controller and defining the base URL for all the endpoints within.
@RestController
@RequestMapping("/api/waiter")
public class WaiterController {

    @Autowired
    private WaiterService waiterService;

    // Endpoint for retrieving all waiters.
    @GetMapping("all")
    public List<Waiter> getAllWaiters() {
        return waiterService.getAll();
    }

    @GetMapping("allNames")
    public List<WaiterDTO> getAllWaiterNameAndId() {
        return waiterService.getAllNameAndId();
    }

}
