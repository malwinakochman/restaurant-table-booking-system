package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "restaurant_table")
public class TableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tableId;

    @Column(name = "seats", nullable = false)
    private Integer numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "waiter_id", nullable = false)
    private Waiter waiter;

}
