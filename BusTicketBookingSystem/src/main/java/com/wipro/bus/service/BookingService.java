
package com.wipro.bus.service;

import com.wipro.bus.dto.BookingDTO;
import com.wipro.bus.entities.Booking;
import java.util.List;

public interface BookingService {

    Booking createBooking(BookingDTO bookingDTO);

    Booking updateBooking(Long bookingId, BookingDTO bookingDTO);

    void cancelBooking(Long bookingId);

    Booking getBookingById(Long bookingId);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByUserId(Long userId);

    // Add this method
    Booking bookTicket(BookingDTO bookingDTO);
}
