package org.example.controllers;

import org.example.models.Restaurant;
import org.example.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Marking this class as a REST controller and defining the base URL for all the endpoints within.
@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Endpoint for retrieving all restaurants.
    @GetMapping("all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAll();
    }
}
