package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperParkingBoyTest {

    @Test
    public void
        should_larger_available_position_rate_parkingLot_when_park_given_different_position_rate_parkingLot()
            throws NoSuchFieldException, IllegalAccessException {
        // Given
        SuperParkingBoy parkingBoy = new SuperParkingBoy();
        ParkingLot firstParkingLot = new ParkingLot(10);
        ParkingLot secondParkingLot = new ParkingLot(100);
        Field currentCapacity = firstParkingLot.getClass().getDeclaredField("currentCapacity");
        currentCapacity.setAccessible(true);
        currentCapacity.set(firstParkingLot, 9);
        currentCapacity.set(secondParkingLot, 9);
        Car car = new Car();
        parkingBoy.workInParkingLot(firstParkingLot);
        parkingBoy.workInParkingLot(secondParkingLot);
        // When
        Ticket ticket = parkingBoy.park(car);

        // Then
        assertEquals(8, firstParkingLot.getCurrentCapacity());
        assertEquals(9, secondParkingLot.getCurrentCapacity());
        assertEquals(firstParkingLot, ticket.getParkingLot());
    }
}
