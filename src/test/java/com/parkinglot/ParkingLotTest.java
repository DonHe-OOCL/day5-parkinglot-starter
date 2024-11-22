package com.parkinglot;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static com.parkinglot.ParkingLot.UNRECOGNIZED_PARKING_TICKET_ERROR_MSG;
import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {

    @Test
    public void should_return_ticket_when_park_given_a_car() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        // When
        Ticket ticket = parkingLot.park(car);

        // Then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_the_car_when_fetch_given_a_ticket() throws Exception {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        // When
        Car fetchCar = parkingLot.fetch(ticket);

        // Then
        assertEquals(car, fetchCar);
    }

    @Test
    public void should_return_right_car_when_fetch_given_two_ticket() throws Exception {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car firstCar = new Car();
        Car secondCar = new Car();
        Ticket firstTicket = parkingLot.park(firstCar);
        Ticket secondTicket = parkingLot.park(secondCar);

        // When
        Car fetchCar = parkingLot.fetch(firstTicket);
        Car secondFetchCar = parkingLot.fetch(secondTicket);
        // Then

        assertEquals(firstCar, fetchCar);
        assertEquals(secondCar, secondFetchCar);
    }

    @Test
    public void should_return_nothing_when_park_given_full_parkingLog_and_a_car() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
        }
        Car car = new Car();

        // When
        cars.forEach(parkingLot::park);
        Ticket ticket = parkingLot.park(car);

        // Then
        assertNull(ticket);
    }

    @Test
    public void should_print_error_message_when_fetch_given_wrong_ticket() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = new Ticket();

        // When
        Ticket ignore = parkingLot.park(car);
        try {
            Car fetch = parkingLot.fetch(ticket);
        } catch (Exception e) {
            // Then
            assertEquals(UNRECOGNIZED_PARKING_TICKET_ERROR_MSG, e.getMessage());
        }
    }

    @Test
    public void should_print_error_message_when_fetch_given_used_ticket() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        // When
        Ticket ticket = parkingLot.park(car);
        try {
            Car fetch = parkingLot.fetch(ticket);
            Car usedFetch = parkingLot.fetch(ticket);
        } catch (Exception e) {
            // Then
            assertEquals(UNRECOGNIZED_PARKING_TICKET_ERROR_MSG, e.getMessage());
        }
    }

}
