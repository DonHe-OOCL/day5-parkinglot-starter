package com.parkinglot;

import com.parkinglot.exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void should_right_car_when_fetch_given_two_ticket() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        Car firstCar = new Car();
        Car secondCar = new Car();

        // When
        Ticket firstTicket = boy.park(firstCar);
        Ticket secondTicket = boy.park(secondCar);

        Car firstFetch = boy.fetch(firstTicket);
        Car secondFetch = boy.fetch(secondTicket);

        // Then
        assertEquals(firstCar, firstFetch);
        assertEquals(secondCar, secondFetch);
    }

    @Test
    public void should_print_error_message_when_fetch_given_wrong_ticket() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        Car car = new Car();
        Ticket ticket = new Ticket();
        // When

        UnrecognizedParkingTicketException exception =
                assertThrows(UnrecognizedParkingTicketException.class, () -> boy.fetch(ticket));
        // Then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
