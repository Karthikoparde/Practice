
package com.wipro.bus.dto;


import java.sql.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PaymentDTO {

    private Long paymentId;

    @NotNull(message = "Booking ID cannot be null")
    private Long bookingId;

    @NotNull(message = "Payment method cannot be null")
    @Size(min = 3, max = 50, message = "Payment method must be between 3 and 50 characters")
    private String paymentMethod;

    @Min(value = 0, message = "Payment amount must be greater than or equal to 0")
    private double paymentAmount;

    @NotNull(message = "Payment status cannot be null")
    @Size(min = 3, max = 50, message = "Payment status must be between 3 and 50 characters")
    private String paymentStatus;

    @NotNull(message = "Payment date cannot be null")
    private Date paymentDate;

    
    public PaymentDTO() {
    }

    
    public PaymentDTO(Long bookingId, String paymentMethod, double paymentAmount, String paymentStatus, Date paymentDate) {
        this.bookingId = bookingId;
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

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
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
}