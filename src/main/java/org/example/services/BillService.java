package org.example.services;

import org.example.models.Bill;
import org.example.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    private final BillRepository billRepository;


    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill getBill(Integer id) {
        return billRepository.findById(id).orElse(null);
    }

    public void deleteBill(Integer id) {
        billRepository.deleteById(id);
    }

    public List<Bill> getAll() {
        return billRepository.findAll();
    }
}
