package org.example.services;

import org.example.models.TableModel;
import org.example.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {
    private final TableRepository tableRepository;
    private final ReservationService reservationService;


    public TableService(TableRepository tableRepository, ReservationService reservationService) {
        this.tableRepository = tableRepository;
        this.reservationService = reservationService;
    }

    public TableModel getTable(Integer id) {
        return tableRepository.findById(id).orElse(null);
    }

    public List<TableModel> getAll() {
        return tableRepository.findAll();
    }

    public List<TableModel> getAllFree(Date date) {
        List<TableModel> reservedTables = reservationService.getAllReservedTables(date);
        List<TableModel> allTables = getAll();

        return allTables.stream()
                .filter(table -> !reservedTables.contains(table))
                .collect(Collectors.toList());
     }
}
