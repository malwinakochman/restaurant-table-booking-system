package org.example.controllers;

import org.example.models.TableModel;
import org.example.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/table")
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
