package org.example.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// Data Transfer Object (DTO) for carrying data between api request and server-side functions.
@Getter
@Setter
public class ReservationRequest {

    private Integer hour;
    private Integer tableId;
    private Integer customerId;
    private Date date;
}
