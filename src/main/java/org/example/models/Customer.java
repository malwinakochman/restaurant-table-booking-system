package org.example.models;

import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "customer_surname", nullable = false, length = 50)
    private String customerSurname;

    @Column(name = "phone", nullable = false, length = 9)
    private String phone;
}
