
package com.wipro.bus.entities;

import jakarta.persistence.*;

@Entity
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    
    private Long scheduleId;
    private String seatNumbers;
    private String bookingDate;
//    private double totalFare;
//    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User user;

   
    public Booking() {
    }

    // Parameterized constructor
    public Booking(User user, Long scheduleId, String seatNumbers, String bookingDate) { //removed double totalFare, String status
        this.user = user; 
        this.scheduleId = scheduleId;
        this.seatNumbers = seatNumbers;
        this.bookingDate = bookingDate;
//        this.totalFare = totalFare;
//        this.status = status;
    }

   
    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

//    public double getTotalFare() {
//        return totalFare;
//    }
//
//    public void setTotalFare(double totalFare) {
//        this.totalFare = totalFare;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
