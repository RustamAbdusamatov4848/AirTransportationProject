package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterTest {

    @Test
    public void shouldTestDepartureBeforeNowFilter() {
        // Given
        FlightFilter filter = new DepartureBeforeNowFilter();
        List<Flight> flights = FlightBuilder.createFlights();

        // When
        List<Flight> filteredFlights = filter.filter(flights);

        // Then
        assertEquals(5, filteredFlights.size());
    }

    @Test
    public void shouldTestArrivalBeforeDepartureFilter() {
        // Given
        FlightFilter filter = new ArrivalBeforeDepartureFilter();
        List<Flight> flights = FlightBuilder.createFlights();

        // When
        List<Flight> filteredFlights = filter.filter(flights);

        // Then
        assertEquals(5, filteredFlights.size());
    }

    @Test
    public void shouldTestExcessiveGroundTimeFilter() {
        // Given
        FlightFilter filter = new ExcessiveGroundTimeFilter();
        List<Flight> flights = FlightBuilder.createFlights();

        // When
        List<Flight> filteredFlights = filter.filter(flights);

        // Then
        assertEquals(4, filteredFlights.size());
    }
}
