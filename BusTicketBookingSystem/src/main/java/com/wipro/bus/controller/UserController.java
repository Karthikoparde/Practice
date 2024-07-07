package com.wipro.bus.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.wipro.bus.entities.User;
import com.wipro.bus.dto.BookingDTO;
import com.wipro.bus.dto.BusSearchDTO;
import com.wipro.bus.entities.Booking;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.service.BookingService;
import com.wipro.bus.service.BusScheduleService;
import com.wipro.bus.service.UserService;
import com.wipro.bus.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private BusScheduleService busScheduleService;
    
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        try {
            User user = userService.loginUser(email, password);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateProfile(@RequestBody User user) {
        try {
            User updatedUser = userService.updateProfile(user);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingService.createBooking(bookingDTO);
        return ResponseEntity.ok(booking);
    }
    
    @DeleteMapping("/delete/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/bookingById/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email) {   //made change here as deleteUserByName to deleteUserByEmail
        boolean isDeleted = userService.deleteUserByEmail(email);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/busSearch")
    public List<BusSchedule> searchBuses(
            @RequestParam String origin,
            @RequestParam String destination) {
        
        BusSearchDTO busSearchDTO = new BusSearchDTO(origin, destination);
        return busScheduleService.searchBuses(busSearchDTO);
    }
    
    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestParam int amount, @RequestParam String currency) {
        try {
            Order order = paymentService.createOrder(amount, currency);
            return ResponseEntity.ok(order.toString());
        } catch (RazorpayException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
