package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name="waiter")
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "waiter_id")
    private Integer waiterId;

    @Column(name = "waiter_name", nullable = false, length = 50)
    private String waiterName;

    @Column(name = "waiter_surname", nullable = false, length = 50)
    private String waiterSurname;

    @Column(name = "served_table", nullable = false)
    private Integer servedTable;

    @Column(name = "phone", nullable = false, length = 9)
    private String phone;
}
