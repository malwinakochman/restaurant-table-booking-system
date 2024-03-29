package org.example.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


import java.time.LocalDateTime;

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
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private TableModel table;

    @Column(name = "customer_surname")
    private String customerSurname;

    @Column(name = "customer_phone", nullable = false)
    private String customerPhone;

}
