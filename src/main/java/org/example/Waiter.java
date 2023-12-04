package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Waiter {
    Integer waiterId;
    String waiterName;
    List<Table> servedTables;
}
