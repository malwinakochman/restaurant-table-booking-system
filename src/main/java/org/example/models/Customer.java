package org.example.models;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "customerSurname", nullable = false, length = 50)
    private String customerSurname;

    @Column(name = "phone", nullable = false, length = 9)
    private String phone;
}
