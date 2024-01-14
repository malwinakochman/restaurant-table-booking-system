package org.example.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ReservationRequest {

    private Integer hour;
    private Integer tableId;
    private Integer customerId;
    private Date date;
}
