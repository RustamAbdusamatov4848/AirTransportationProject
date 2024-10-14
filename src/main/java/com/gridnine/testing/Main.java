package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();
        System.out.println("1. Flights departing after current time:");
        filterAccordingFlightFilter(flightList, new DepartureBeforeNowFilter());
        System.out.println("2. Flights without segments, where arrival is before departure:");
        filterAccordingFlightFilter(flightList,new ArrivalBeforeDepartureFilter());
        System.out.println("3. Flights without excessive time on the ground:");
        filterAccordingFlightFilter(flightList,new ExcessiveGroundTimeFilter());
    }

    private static void filterAccordingFlightFilter(List<Flight> flightList, FlightFilter flightFilter) {
        List<Flight> filteredFlightsByArrival  = flightFilter.filter(flightList);
        filteredFlightsByArrival .forEach(System.out::println);
    }
}
