package org.example.repositories;

import org.example.models.Reservation;
import org.example.models.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//Interface with set of methods that give us the opportunity to interact with database
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByDate(Date date);

    @Query("SELECT DISTINCT r.table FROM Reservation r WHERE r.date = :date")
    List<TableModel> findReservedTablesByDate(@Param("date") Date date);

}
