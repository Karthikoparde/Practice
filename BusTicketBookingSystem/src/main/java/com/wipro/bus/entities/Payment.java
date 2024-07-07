package com.wipro.bus.entities;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

  
    
    
    private String paymentMethod;
    private double paymentAmount;
    private String paymentStatus;
    private Date paymentDate;
    
    
    @OneToOne
    @JoinColumn(name = "booking_id") 
    private Booking booking;

   
    public Payment() {
    }

    
    public Payment(Booking booking, String paymentMethod, double paymentAmount, String paymentStatus, Date paymentDate) {
        this.booking = booking;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
        this.paymentDate = paymentDate;
    }

    
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

   
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
