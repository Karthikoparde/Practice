package com.wipro.bus.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.bus.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
  
}
