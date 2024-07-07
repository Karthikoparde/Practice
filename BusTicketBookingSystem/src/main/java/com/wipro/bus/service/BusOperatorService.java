package com.wipro.bus.service;

import java.util.List;

import com.wipro.bus.entities.BusOperator;
//import com.wipro.bus.entities.BusRoute;

public interface BusOperatorService {
	
    BusOperator loginBusOperator(String email, String password);
    
 // Use Case: Manage the Route
//    void manageRoute(Long busOperatorId, List<BusRoute> routes);
    
    // Use Case: Log Out
    void logoutBusOperator(Long busOperatorId);
    
    boolean deleteBusOperator(String email);
    
}
