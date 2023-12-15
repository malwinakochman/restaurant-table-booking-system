package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Dishes")
@Getter
@Setter
@Data
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
