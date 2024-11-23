package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {

    @Test
    public void should_park_more_slot_parkingLot_when_park_given_two_different_space_parkingLot_and_a_car() {
        // Given
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        ParkingLot firstParkingLot = new ParkingLot(10);
        ParkingLot secondParkingLot = new ParkingLot(20);
        Car car = new Car();
        parkingBoy.workInParkingLot(firstParkingLot);
        parkingBoy.workInParkingLot(secondParkingLot);
        // When
        Ticket ticket = parkingBoy.park(car);
        // Then
        assertEquals(19, secondParkingLot.getCurrentCapacity());
        assertEquals(secondParkingLot, ticket.getParkingLot());
    }
}
