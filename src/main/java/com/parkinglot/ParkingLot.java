package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static final Integer DEFAULT_CAPACITY = 10;
    public static final String UNRECOGNIZED_PARKING_TICKET_ERROR_MSG = "Unrecognized parking ticket.";

    public static final String NO_AVAILABLE_ERROR_MSG = "No available position.";

    private Integer capacity;

    private final Map<Ticket, Car> parkingRecords = new HashMap<>();

    public ParkingLot() {
        capacity = 0;
    }

    public Ticket park(Car car) {
        if (!checkParkAvailable()) {
            throw new NoAvailablePositionException();
        }
        Ticket ticket = new Ticket();
        parkingRecords.put(ticket, car);
        capacity++;
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        Car fetch = parkingRecords.remove(ticket);
        if (fetch != null) {
            capacity--;
        } else {
            throw new UnrecognizedParkingTicketException();
        }
        return fetch;
    }

    public boolean checkParkAvailable() {
        return capacity < DEFAULT_CAPACITY;
    }
}
