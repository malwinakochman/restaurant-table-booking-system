package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Defines the Bill entity with its table mapping and column definitions. (Representation of database table as class)
@Entity
@Table(name = "bill")
@Getter
@Setter
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer billId;

    @Column(name = "bill_price", nullable = false)
    private BigDecimal billPrice;

    @Column(name = "is_payed", nullable = false)
    private Boolean isPayed;

    @Column(name = "list_of_dishes", nullable = false, length = 50)
    private String listOfDishes;

    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id")
    private Reservation reservation;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "waiter_id", referencedColumnName = "waiter_id", nullable = false)
    private Waiter waiter;

}
