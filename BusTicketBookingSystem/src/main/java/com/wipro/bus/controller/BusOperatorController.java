package com.wipro.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.service.BusOperatorService;
import com.wipro.bus.service.BusScheduleService;

@RestController
@RequestMapping("/api/busOperator")
public class BusOperatorController {

    @Autowired
    private BusOperatorService busOperatorService;

    @Autowired
    private BusScheduleService busScheduleService;

    @PostMapping("/login")
    public ResponseEntity<BusOperator> loginBusOperator(@RequestParam String email, @RequestParam String password) {
        try {
            BusOperator busOperator = busOperatorService.loginBusOperator(email, password);
            return ResponseEntity.ok(busOperator);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
 // Create a new bus schedule
    @PostMapping("/createSchedule")
    public ResponseEntity<BusSchedule> createBusSchedule(@RequestBody BusSchedule busSchedule) {
        try {
            BusSchedule createdBusSchedule = busScheduleService.createBusSchedule(busSchedule);
            return ResponseEntity.ok(createdBusSchedule);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    
}
