package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_given_a_car() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        Car car = new Car();
        // When
        Ticket ticket = boy.park(car);
        // Then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_fetch_given_a_ticket() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        Car car = new Car();
        // When
        Ticket ticket = boy.park(car);
        Car fetchCar = boy.fetch(ticket);

        // Then
        assertEquals(car, fetchCar);
    }
}
