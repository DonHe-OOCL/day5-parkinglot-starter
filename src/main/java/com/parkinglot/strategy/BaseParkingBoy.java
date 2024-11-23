package com.parkinglot.strategy;

import com.parkinglot.Car;
import com.parkinglot.ParkingLot;
import com.parkinglot.Ticket;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseParkingBoy implements ParkingStrategy {

    protected final List<ParkingLot> parkingLots = new ArrayList<>();

    public void workInParkingLot(ParkingLot lot) {
        parkingLots.add(lot);
    }

    public Car fetch(Ticket ticket) {
        ParkingLot parkingLot = ticket.getParkingLot();
        return parkingLot.fetch(ticket);
    }

}
