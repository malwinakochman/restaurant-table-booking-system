package org.example.controllers;

import org.example.models.Waiter;
import org.example.services.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/waiter")
@CrossOrigin(origins = "http://localhost:8080")  // Dostosuj do adresu frontendu
public class WaiterController {
    @Autowired
    private WaiterService waiterService;

    @GetMapping("all")
    public List<Waiter> getAllWaiters() {
        return waiterService.getAll();
    }

}
