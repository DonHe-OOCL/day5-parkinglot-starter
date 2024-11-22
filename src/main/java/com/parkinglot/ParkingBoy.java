package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingBoy() {
    }

    public void workInParkingLot(ParkingLot lot) {
        parkingLots.add(lot);
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream().filter(ParkingLot::checkParkAvailable).findFirst().orElse(null);
        if (parkingLot == null) {
            throw new NoAvailablePositionException();
        }
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLot = ticket.getParkingLot();
        return parkingLot.fetch(ticket);
    }
}
