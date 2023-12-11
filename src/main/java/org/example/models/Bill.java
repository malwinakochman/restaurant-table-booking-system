package org.example.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;

    @Column(name = "billPrice", nullable = false)
    private BigDecimal billPrice;

    @Column(name = "isPayed", nullable = false)
    private Boolean isPayed;

    @Column(name = "listOfDishes", nullable = false, length = 50)
    private String listOfDishes;

}
