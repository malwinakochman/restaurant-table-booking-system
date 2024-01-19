package org.example.services;

import org.example.models.Waiter;
import org.example.repositories.WaiterRepository;
import org.example.requests.WaiterDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaiterService {
    private final WaiterRepository waiterRepository;


    public WaiterService(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
    }

    public Waiter saveWaiter(Waiter waiter) {
        return waiterRepository.save(waiter);
    }

    public Waiter getWaiter(Integer id) {
        return waiterRepository.findById(id).orElse(null);
    }

    public void deleteWaiter(Integer id) {
        waiterRepository.deleteById(id);
    }

    public List<Waiter> getAll() {
        return waiterRepository.findAll();
    }

    public List<WaiterDTO> getAllNameAndId() {
        return waiterRepository.findAllWaiterNamesAndId();
    }
}
