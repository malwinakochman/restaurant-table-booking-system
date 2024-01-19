package org.example.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// Data Transfer Object (DTO) for carrying data between api request and server-side functions.
@Getter
@Setter
public class ReservationRequest {

    private Integer hour;
    private Integer tableId;
    private Integer customerId;
    private LocalDateTime date;
}
