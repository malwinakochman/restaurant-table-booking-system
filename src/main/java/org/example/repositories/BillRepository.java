package org.example.repositories;

import org.example.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

//Interface with set of methods that give us the opportunity to interact with database
@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query("SELECT b FROM Bill b WHERE " +
            "(:startOfDay IS NULL OR b.date >= :startOfDay) AND (:endOfDay IS NULL OR b.date < :endOfDay) AND " +
            "(:waiterId IS NULL OR b.waiter.waiterId = :waiterId) AND " +
            "(:isPayed IS NULL OR b.isPayed = :isPayed) AND " +
            "(:reservationId IS NULL OR b.reservation.reservationId = :reservationId)")
    List<Bill> findBillsByCriteria(@Param("startOfDay") LocalDateTime startOfDay,
                                   @Param("endOfDay") LocalDateTime endOfDay,
                                   @Param("waiterId") Integer waiterId,
                                   @Param("isPayed") Boolean isPayed,
                                   @Param("reservationId") Integer reservationId);

}
