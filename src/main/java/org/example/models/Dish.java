package org.example.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dishId;

    @Column(name = "dishName", nullable = false, length = 50)
    private String dishName;

    @Column(name = "dishPrice", nullable = false)
    private BigDecimal dishPrice;

    @Column(name = "dishType", nullable = false, length = 50)
    private DishType dishType;
}
