package com.wipro.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wipro.bus.entities.Administrator;
import com.wipro.bus.entities.BusOperator;

import jakarta.transaction.Transactional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    // Custom query methods (if any) can be added here
	Administrator findByEmail(String email);
	Administrator findByEmailAndPassword(String email, String password);

}
