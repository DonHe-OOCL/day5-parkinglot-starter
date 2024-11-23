package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy {
    private final List<ParkingLot> parkingLots = new ArrayList<>();

    public SmartParkingBoy() {
    }

    public void workInParkingLot(ParkingLot lot) {
        parkingLots.add(lot);
    }

    public Ticket park(Car car) {
        Optional<ParkingLot> parkingLotOptional =
                parkingLots.stream()
                        .filter(ParkingLot::checkParkAvailable)
                        .findFirst();
        if (parkingLotOptional.isPresent()) {
            return parkingLotOptional.get().park(car);
        }
        throw new NoAvailablePositionException();
    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLot = ticket.getParkingLot();
        return parkingLot.fetch(ticket);
    }
}
