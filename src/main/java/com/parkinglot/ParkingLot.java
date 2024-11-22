package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> parkingRecords = new HashMap<>();

    public ParkingLot() {
    }

    public ParkingLot(Integer capacity) {

    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        parkingRecords.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return parkingRecords.remove(ticket);
    }
}
