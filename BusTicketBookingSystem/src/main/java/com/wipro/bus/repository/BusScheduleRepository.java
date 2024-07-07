package com.wipro.bus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.entities.User;

import jakarta.transaction.Transactional;

@Repository
public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
	List<BusSchedule> findByOriginAndDestination(String origin, String destination);
	BusSchedule findByScheduleId(Long scheduleId);
	
}
