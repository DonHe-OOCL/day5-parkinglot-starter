package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {

    @Test
    public void should_return_ticket_when_park_given_a_car() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        // When
        Ticket ticket = null;
        try {
            ticket = parkingLot.park(car);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
    public void should_print_error_message_when_park_given_full_parkingLog_and_a_car() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
        }
        Car car = new Car();

        // When
        try {
            for (Car parkCar : cars) {
                parkingLot.park(parkCar);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        NoAvailablePositionException exception =
                assertThrows(NoAvailablePositionException.class, () -> parkingLot.park(car));

        // Then
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void should_print_error_message_when_fetch_given_wrong_ticket() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = new Ticket();

        // When
        try {
            Ticket ignore = parkingLot.park(car);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Car fetch = parkingLot.fetch(ticket);
        } catch (Exception e) {
            // Then
            assertEquals("Unrecognized parking ticket.", e.getMessage());
        }
    }

    @Test
    public void should_print_error_message_when_fetch_given_used_ticket() {
        // Given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        // When
        Ticket ticket = null;
        try {
            ticket = parkingLot.park(car);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Car fetch = parkingLot.fetch(ticket);
            Car usedFetch = parkingLot.fetch(ticket);
        } catch (Exception e) {
            // Then
            assertEquals("Unrecognized parking ticket.", e.getMessage());
        }
    }

}
