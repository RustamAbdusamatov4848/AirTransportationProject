package com.gridnine.testing;

import java.time.Duration;
import java.util.List;

public class ExcessiveGroundTimeFilter implements FlightFilter {
    private static final long MAX_GROUND_TIME_MINUTES = 120;

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(this::hasExcessiveGroundTime)
                .toList();
    }

    private boolean hasExcessiveGroundTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        Duration totalGroundTime = Duration.ZERO;

        for (int i = 0; i < segments.size() - 1; i++) {
            Segment currentSegment = segments.get(i);
            Segment nextSegment = segments.get(i + 1);
            Duration groundTime = Duration.between(currentSegment.getArrivalDate(), nextSegment.getDepartureDate());
            totalGroundTime = totalGroundTime.plus(groundTime);

            if (totalGroundTime.toMinutes() > MAX_GROUND_TIME_MINUTES) {
                return false;
            }
        }

        return true;
    }
}
