package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class DepartureBeforeNowFilter implements FlightFilter{
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        LocalDateTime currentTime = LocalDateTime.now();
        return flightList
                .stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(currentTime)))
                .toList();
    }
}
