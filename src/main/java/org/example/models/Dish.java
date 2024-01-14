package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

// Defines the Bill entity with its table mapping and column definitions. (Representation of database table as class)
@Entity
@Table(name = "dishes")
@Getter
@Setter
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private Integer dishId;

    @Column(name = "dish_name", nullable = false, length = 50)
    private String dishName;

    @Column(name = "dish_price", nullable = false)
    private BigDecimal dishPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_type", nullable = false, length = 50)
    private DishType dishType;
}
