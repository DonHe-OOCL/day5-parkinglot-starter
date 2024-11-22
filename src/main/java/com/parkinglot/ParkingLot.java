package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static final Integer DEFAULT_CAPACITY = 10;

    private Integer capacity;

    private Integer usedSlots;

    private final Map<Ticket, Car> parkingRecords = new HashMap<>();

    public ParkingLot() {
        capacity = DEFAULT_CAPACITY;
        usedSlots = 0;
    }

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        usedSlots = 0;
    }

    public Ticket park(Car car) {
        if ((int) capacity == usedSlots) {
            return null;
        }
        Ticket ticket = new Ticket();
        parkingRecords.put(ticket, car);
        usedSlots++;
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car fetch = parkingRecords.remove(ticket);
        if (fetch != null) {
            usedSlots--;
        }
        return fetch;
    }
}
