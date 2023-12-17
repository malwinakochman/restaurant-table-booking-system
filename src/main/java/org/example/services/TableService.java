package org.example.services;

import jakarta.persistence.Table;
import org.example.models.TableModel;
import org.example.repositories.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {
    private final TableRepository tableRepository;


    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public TableModel saveTable(TableModel table) {
        return tableRepository.save(table);
    }

    public TableModel getTable(Integer id) {
        return tableRepository.findById(id).orElse(null);
    }

    public void deleteTable(Integer id) {
        tableRepository.deleteById(id);
    }

    public List<TableModel> getAll() {
        return tableRepository.findAll();
    }
}
