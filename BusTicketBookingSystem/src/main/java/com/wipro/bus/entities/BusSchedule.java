package com.wipro.bus.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class BusSchedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String busName;
    private String busNumber;
    private String busType;
    private int numOfSeats;
    private String origin;
    private String destination;
//    private Date scheduleDate;
    private String timings;
    private double fare;

    // Default constructor
    public BusSchedule() {
    }

    // Parameterized constructor
    public BusSchedule(String busName, String busNumber, String busType, int numOfSeats, String origin, String destination, String timings) {
        this.busName = busName;
        this.busNumber = busNumber;
        this.busType = busType;
        this.numOfSeats = numOfSeats;
        this.origin = origin;
        this.destination = destination;
//        this.scheduleDate = scheduleDate;
        this.timings = timings;
        
    }

    
    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
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

//    public Date getScheduleDate() {
//		return scheduleDate;
//	}
//
//	public void setScheduleDate(Date scheduleDate) {
//		this.scheduleDate = scheduleDate;
//	}

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
