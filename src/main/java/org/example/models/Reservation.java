package org.example.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


import java.util.Date;

@Data
@Table(name = "reservation")
@Getter
@Setter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    @Column(name = "hour", nullable = false)
    private Integer hour;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private TableModel table;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
