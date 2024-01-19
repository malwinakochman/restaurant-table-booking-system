package org.example.controllers;

import org.example.models.TableModel;
import org.example.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

// Marking this class as a REST controller and defining the base URL for all the endpoints within.
@RestController
@RequestMapping("/api/table")
public class TableController {
    @Autowired
    private TableService tableService;

    // Endpoint for retrieving all tables.
    @GetMapping("all")
    public List<TableModel> getAllTables() {
        return tableService.getAll();
    }

    // Endpoint for retrieving all free (not reserved) tables.
    @GetMapping("allFree")
    public List<TableModel> getAllFreeTables(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime date) {
        return tableService.getAllFree(date);
    }
}
