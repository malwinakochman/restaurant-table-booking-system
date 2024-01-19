package org.example.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Date;

// Defines the Bill entity with its table mapping and column definitions. (Representation of database table as class)
@Data
@Table(name = "reservation")
@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private TableModel table;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
