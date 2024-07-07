package com.wipro.bus.service;

import com.wipro.bus.entities.Administrator;
import com.wipro.bus.entities.BusOperator;


public interface AdministratorService {
    Administrator registerAdministrator(Administrator administrator);
    Administrator loginAdministrator(String email, String password);
    
 // Use Case: Add a Bus Operator
    BusOperator addBusOperator(BusOperator busOperator);
    
    // Use Case: Delete a Bus Operator
    boolean deleteBusOperator(String email);
    
//    // Use Case: Logout Administrator
//    void logoutAdministrator(Long administratorId);
    
 // Use Case: Delete a User by Email
    boolean deleteUser(String email);

}
