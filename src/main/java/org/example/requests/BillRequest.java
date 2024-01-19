package org.example.requests;


import lombok.Getter;
import lombok.Setter;
import org.example.models.Waiter;

import java.math.BigDecimal;
import java.util.Date;

// Data Transfer Object (DTO) for carrying data between api request and server-side functions.
@Getter
@Setter
public class BillRequest {

    private Integer billId;

    private BigDecimal billPrice;

    private Boolean isPayed;

    private String listOfDishes;

    private Date date;

    private Integer reservationId;

    private Integer waiterId;

}
