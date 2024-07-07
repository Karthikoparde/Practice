package com.wipro.bus.dto;


public class BusSearchResultDTO {
    private Long routeId;
    private String origin;
    private String destination;
    private Double fare;
    // Add more fields as needed
    
    // Constructors, getters, and setters
    public BusSearchResultDTO() {
    }

    public BusSearchResultDTO(Long routeId, String origin, String destination, Double fare) {
        this.routeId = routeId;
        this.origin = origin;
        this.destination = destination;
        this.fare = fare;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
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

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
    
    // Add more getters and setters for additional fields if necessary
}
