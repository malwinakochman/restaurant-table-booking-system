package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Bill")
@Getter
@Setter
@Data
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
