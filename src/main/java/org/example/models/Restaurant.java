package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// Defines the Bill entity with its table mapping and column definitions. (Representation of database table as class)@Data
@Table(name = "restaurant")
@Getter
@Setter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "street", nullable = false, length = 50)
    private String street;

    @Column(name = "postal_code", nullable = false, length = 6)
    private String postalCode;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "building_number", nullable = false, length = 5)
    private String buildingNumber;

    @Column(name = "tables", nullable = false)
    private Integer numberOfTables;

    @Column(name = "waiters", nullable = false)
    private Integer numberOfWaiters;

}
