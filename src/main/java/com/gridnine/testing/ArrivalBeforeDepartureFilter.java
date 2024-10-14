package com.gridnine.testing;

import java.util.List;

public class ArrivalBeforeDepartureFilter implements FlightFilter{
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        return flightList
                .stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .allMatch(segment -> !segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .toList();
    }
}
