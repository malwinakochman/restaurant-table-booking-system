package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "dishes")
@Getter
@Setter
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dishId;

    @Column(name = "dish_name", nullable = false, length = 50)
    private String dishName;

    @Column(name = "dish_price", nullable = false)
    private BigDecimal dishPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_type", nullable = false, length = 50)
    private DishType dishType;
}
