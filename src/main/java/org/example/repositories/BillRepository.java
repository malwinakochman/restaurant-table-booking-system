package org.example.repositories;

import org.example.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface with set of methods that give us the opportunity to interact with database
@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
}
