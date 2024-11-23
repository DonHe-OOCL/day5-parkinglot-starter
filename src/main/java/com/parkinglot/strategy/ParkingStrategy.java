package com.parkinglot.strategy;

import com.parkinglot.Car;
import com.parkinglot.Ticket;

public interface ParkingStrategy {
    Ticket park(Car car);

}
