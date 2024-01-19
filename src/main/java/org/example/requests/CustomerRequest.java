package org.example.requests;
import lombok.Getter;
import lombok.Setter;

// Data Transfer Object (DTO) for carrying data between api request and server-side functions.
@Getter
@Setter
public class CustomerRequest {

    private Integer customerId;
    private String customerSurname;
    private String customerPhone;

}