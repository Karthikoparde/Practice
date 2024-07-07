package com.wipro.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.User;
import com.wipro.bus.entities.Booking;
import com.wipro.bus.repository.UserRepository;

import jakarta.transaction.Transactional;

import com.wipro.bus.repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public User registerUser(User user) {
    	if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists with this email");
        }
        return userRepository.save(user);    }

    @Override
    public User updateProfile(User user) {
        // Implement update profile logic, e.g., update user details in the database
        return userRepository.save(user);
    }

    @Override
    public List<Booking> viewBookingHistory(Long userId) {
        // Implement logic to fetch booking history for a user
        return bookingRepository.findByUser_UserId(userId);
    }

    @Override
    public boolean cancelBooking(Long bookingId) {
        if (bookingRepository.existsById(bookingId)) {
            bookingRepository.deleteById(bookingId);
            return true;
        }
        return false;
    }

    @Override
    public User loginUser(String email, String password) {
        // Find user by email
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Invalid email or password");
    }
	@Transactional
	@Override
	public boolean deleteUserByEmail(String email) {
		 Optional<User> userOptional = userRepository.deleteByEmail(email);
	        if (userOptional.isPresent()) {
	            userRepository.deleteByEmail(email);
	            userRepository.resetAutoIncrement();  // Reset auto-increment value

	            return true;
	        }
	        return false;
	}


}
