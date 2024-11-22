package com.parkinglot;

import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    public void should_return_ticket_when_park_given_a_car() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        boy.workInParkingLot(parkingLot);
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
        ParkingLot parkingLot = new ParkingLot();
        boy.workInParkingLot(parkingLot);
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
        ParkingLot parkingLot = new ParkingLot();
        boy.workInParkingLot(parkingLot);
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
        ParkingLot parkingLot = new ParkingLot();
        ParkingLot otherParkingLot = new ParkingLot();
        boy.workInParkingLot(parkingLot);
        Car car = new Car();
        Ticket ticket = new Ticket(otherParkingLot);
        // When
        UnrecognizedParkingTicketException exception =
                assertThrows(UnrecognizedParkingTicketException.class, () -> boy.fetch(ticket));
        // Then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_print_error_message_when_fetch_given_used_ticket() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        boy.workInParkingLot(parkingLot);
        Car car = new Car();
        // When
        Ticket ticket = boy.park(car);
        boy.fetch(ticket);
        UnrecognizedParkingTicketException exception =
                assertThrows(UnrecognizedParkingTicketException.class, () -> boy.fetch(ticket));
        // Then
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_print_error_message_when_park_given_full_parkingLog_and_a_car() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        boy.workInParkingLot(parkingLot);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
        }
        Car car = new Car();

        // When
        try {
            for (Car parkCar : cars) {
                boy.park(parkCar);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        NoAvailablePositionException exception =
                assertThrows(NoAvailablePositionException.class, () -> boy.park(car));

        // Then
        assertEquals("No available position.", exception.getMessage());
    }

    @Test
    public void should_park_to_first_lot_when_park_given_two_parking_lot() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot seconedParkingLot = new ParkingLot();
        boy.workInParkingLot(firstParkingLot);
        boy.workInParkingLot(seconedParkingLot);
        Car car = new Car();

        // When
        Ticket ticket = boy.park(car);

        // Then
        assertEquals(firstParkingLot, ticket.getParkingLot());
    }
    
    @Test
    public void should_park_to_second_lot_when_park_given_first_full_lot() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot seconedParkingLot = new ParkingLot();
        boy.workInParkingLot(firstParkingLot);
        boy.workInParkingLot(seconedParkingLot);
        Car car = new Car();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cars.add(new Car());
        }
        try {
            for (Car parkCar : cars) {
                boy.park(parkCar);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // When
        Ticket ticket = boy.park(car);

        // Then
        assertEquals(seconedParkingLot, ticket.getParkingLot());
    }

    @Test
    public void should_right_car_when_parkingBoy_fetch_given_two_ticket() {
        // Given
        ParkingBoy boy = new ParkingBoy();
        ParkingLot firstParkingLot = new ParkingLot();
        ParkingLot seconedParkingLot = new ParkingLot();
        boy.workInParkingLot(firstParkingLot);
        boy.workInParkingLot(seconedParkingLot);
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
}
