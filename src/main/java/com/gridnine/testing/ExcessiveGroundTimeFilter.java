package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ExcessiveGroundTimeFilter implements FlightFilter{
    private static final Duration MAX_GROUND_TIME = Duration.ofHours(2);

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> calculateTotalGroundTime(flight).compareTo(MAX_GROUND_TIME) <= 0)
                .toList();
    }

    private Duration calculateTotalGroundTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        Duration totalGroundTime = Duration.ZERO;

        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrivalTime = segments.get(i).getArrivalDate();
            LocalDateTime nextDepartureTime = segments.get(i + 1).getDepartureDate();
            totalGroundTime = totalGroundTime.plus(Duration.between(arrivalTime, nextDepartureTime));
        }

        return totalGroundTime;
    }
}
