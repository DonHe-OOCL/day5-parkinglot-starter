package com.parkinglot.exception;

import static com.parkinglot.ParkingLot.NO_AVAILABLE_ERROR_MSG;

public class NoAvailablePositionException extends RuntimeException {
    public NoAvailablePositionException() {
        super(NO_AVAILABLE_ERROR_MSG);
    }
}
