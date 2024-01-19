package org.example.requests;


import lombok.Getter;
import lombok.Setter;
import org.example.models.Dish;

import java.math.BigDecimal;
import java.util.List;

// Data Transfer Object (DTO) for carrying data between api request and server-side functions.
@Getter
@Setter
public class BillRequest {

    private Integer billId;

    private BigDecimal billPrice;

    private Boolean isPayed;

    private List<Dish> listOfDishes;

    private Integer reservationId;

    private Integer waiterId;

}
