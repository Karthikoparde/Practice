package com.wipro.bus.entities;

public class BusSearch {

    private String origin;
    private String destination;

    // Default constructor
    public BusSearch() {
    }

    // Parameterized constructor
    public BusSearch(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
