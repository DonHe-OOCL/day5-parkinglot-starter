package com.parkinglot.strategy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;
import com.parkinglot.exception.NoAvailablePositionException;

import java.util.Comparator;
import java.util.Optional;

public class SuperParkingBoy extends BaseParkingBoy{
    @Override
    public Ticket park(Car car) {
        Optional<ParkingLot> parkingLotOptional = parkingLots.stream()
                .filter(ParkingLot::checkParkAvailable)
                .max(Comparator.comparingDouble(ParkingLot::getAvailablePositionRate));
        if (parkingLotOptional.isPresent()) {
            return parkingLotOptional.get().park(car);
        }
        throw new NoAvailablePositionException();
    }
}
