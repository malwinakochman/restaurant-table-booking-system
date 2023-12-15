package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name="Waiter")
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer waiterId;

    @Column(name = "waiterName", nullable = false, length = 50)
    private String waiterName;

    @Column(name = "waiterSurname", nullable = false, length = 50)
    private String waiterSurname;

    @Column(name = "servedTable", nullable = false)
    private Integer servedTable;

    @Column(name = "phone", nullable = false, length = 9)
    private String phone;
}
