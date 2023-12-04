package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Reservation {
    Integer reservationId;
    LocalTime hour;
    Date date;
    Table table;
    Customer customer;
    List<Dish> dishes;
}
