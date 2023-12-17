package org.example.services;

import org.example.models.Customer;
import org.example.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
