package org.example.requests;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BillRequest {

    private Integer billId;

    private BigDecimal billPrice;

    private Boolean isPayed;

    private String listOfDishes;

}
