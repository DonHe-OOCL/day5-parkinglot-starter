package com.parkinglot.exception;

import com.parkinglot.ParkingLot;

public class UnrecognizedParkingTicketException extends RuntimeException {
    public UnrecognizedParkingTicketException() {
        super(ParkingLot.UNRECOGNIZED_PARKING_TICKET_ERROR_MSG);
    }
}

