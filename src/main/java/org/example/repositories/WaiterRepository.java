package org.example.repositories;

import org.example.models.Waiter;
import org.example.requests.WaiterDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//Interface with set of methods that give us the opportunity to interact with database
@Repository
public interface WaiterRepository extends JpaRepository<Waiter, Integer> {

    @Query("SELECT new org.example.requests.WaiterDTO(w.waiterId, w.waiterName, w.waiterSurname) FROM Waiter w")
    List<WaiterDTO> findAllWaiterNamesAndId();

}
