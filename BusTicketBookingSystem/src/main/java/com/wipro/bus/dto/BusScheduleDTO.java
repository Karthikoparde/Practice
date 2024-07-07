package com.wipro.bus.dto;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Positive;

public class BusScheduleDTO {

    private Long routeId;

    @NotBlank(message = "Bus name is mandatory")
    private String busName;

    @NotBlank(message = "Bus number is mandatory")
    @Size(max = 10, message = "Bus number can have at most 10 characters")
    private String busNumber;

    @NotBlank(message = "Bus type is mandatory")
    private String busType;

    @Min(value = 1, message = "Number of seats must be at least 1")
    private int numOfSeats;

    @NotBlank(message = "Origin is mandatory")
    private String origin;

    @NotBlank(message = "Destination is mandatory")
    private String destination;

    @NotBlank(message = "Timings are mandatory")
    private String timings;

    @Positive(message = "Fare must be positive")
    private double fare;


    
    public BusScheduleDTO() {
    }

    
    public BusScheduleDTO(String busName, String busNumber, String busType, int numOfSeats, String origin, String destination, String timings, double fare) {
        this.busName = busName;
        this.busNumber = busNumber;
        this.busType = busType;
        this.numOfSeats = numOfSeats;
        this.origin = origin;
        this.destination = destination;
        this.timings = timings;
        this.fare = fare;
    }

    
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
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

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
    
}
