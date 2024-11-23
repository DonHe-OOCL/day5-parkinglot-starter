package com.parkinglot.strategy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import com.parkinglot.exception.NoAvailablePositionException;

import java.util.Comparator;
import java.util.Optional;

public class SmartParkingBoy extends BaseParkingBoy {
    @Override
    public Ticket park(Car car) {
        Optional<ParkingLot> parkingLotOptional =
                parkingLots.stream()
                        .filter(ParkingLot::checkParkAvailable)
                        .max(Comparator.comparingInt(ParkingLot::getCurrentCapacity));
        if (parkingLotOptional.isPresent()) {
            return parkingLotOptional.get().park(car);
        }
        throw new NoAvailablePositionException();
    }
}
