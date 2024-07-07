package com.wipro.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wipro.bus.entities.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);    
	
	Optional<User> deleteByEmail(String email);
	@Modifying
    @Transactional
    @Query(value = "ALTER TABLE user AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
}
