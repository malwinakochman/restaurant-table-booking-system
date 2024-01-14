package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// Defines the Bill entity with its table mapping and column definitions. (Representation of database table as class)
@Getter
@Setter
@Entity
@Data
@Table(name = "restaurant_table")
public class TableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Integer tableId;

    @Column(name = "seats", nullable = false)
    private Integer numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "waiter_id", nullable = false)
    private Waiter waiter;

}
