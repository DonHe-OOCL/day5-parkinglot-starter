package com.parkinglot;

public class Ticket {

    public Ticket() {
    }

    public Ticket(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
