package org.example.models;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    @Column(name = "hour", nullable = false)
    private Integer hour;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "tableId", nullable = false)
    private TTable table;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

}
