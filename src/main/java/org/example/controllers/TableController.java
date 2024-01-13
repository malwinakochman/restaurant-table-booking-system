package org.example.controllers;

import org.example.models.TableModel;
import org.example.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/table")
@CrossOrigin(origins = "http://localhost:8080")  // Dostosuj do adresu frontendu
public class TableController {
    @Autowired
    private TableService tableService;

    @GetMapping("all")
    public List<TableModel> getAllTables() {
        return tableService.getAll();
    }

    @GetMapping("allFree")
    public List<TableModel> getAllFreeTables(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return tableService.getAllFree(date);
    }
}
