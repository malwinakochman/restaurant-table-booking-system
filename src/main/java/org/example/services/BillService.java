package org.example.services;

import org.example.models.Bill;
import org.example.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public List<Bill> getBillsByFilter(LocalDate date, Integer waiterId, Boolean isPayed, Integer reservationId) {
        LocalDateTime startOfDay = null;
        LocalDateTime endOfDay = null;

        if (date != null) {
            startOfDay = date.atStartOfDay();
            endOfDay = date.plusDays(1).atStartOfDay();
        }
        return billRepository.findBillsByCriteria(startOfDay, endOfDay, waiterId, isPayed, reservationId);
    }
}
