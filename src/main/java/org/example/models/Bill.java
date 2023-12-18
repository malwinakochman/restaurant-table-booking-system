package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

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

}
