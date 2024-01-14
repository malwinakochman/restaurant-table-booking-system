package org.example.controllers;

import org.example.models.Dish;
import org.example.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Marking this class as a REST controller and defining the base URL for all the endpoints within.
@RestController
@RequestMapping("/api/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    // Endpoint for retrieving all dishes.
    @GetMapping("all")
    public List<Dish> getAllDishes() {
        return dishService.getAll();
    }
}
