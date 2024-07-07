package com.wipro.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.entities.User;

import jakarta.transaction.Transactional;

public interface BusOperatorRepository extends JpaRepository<BusOperator, Long> {
	BusOperator findByEmail(String email); 
	
	Optional<BusOperator> deleteByEmail(String email);
	@Modifying
    @Transactional
    @Query(value = "ALTER TABLE bus_operator AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
	
}

