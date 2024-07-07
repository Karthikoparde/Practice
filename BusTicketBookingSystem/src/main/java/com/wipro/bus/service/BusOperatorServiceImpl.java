package com.wipro.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.BusSchedule;
//import com.wipro.bus.entities.BusRoute;
import com.wipro.bus.entities.User;
import com.wipro.bus.repository.BusOperatorRepository;
import com.wipro.bus.repository.BusScheduleRepository;
import com.wipro.bus.service.BusOperatorService;

import jakarta.transaction.Transactional;

@Service
public class BusOperatorServiceImpl implements BusOperatorService {

    @Autowired
    private BusOperatorRepository busOperatorRepository;
    
    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Override
    public BusOperator loginBusOperator(String email, String password) {
        BusOperator busOperator = busOperatorRepository.findByEmail(email);
        if (busOperator != null && busOperator.getPassword().equals(password)) {
            return busOperator;
        }
        throw new RuntimeException("Invalid email or password");
    }

//	@Override
//	public void manageRoute(Long busOperatorId, List<BusRoute> routes) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void logoutBusOperator(Long busOperatorId) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public boolean deleteBusOperator(String email) {
		 Optional<BusOperator> busOperatorOptional = busOperatorRepository.deleteByEmail(email);
	        if (busOperatorOptional.isPresent()) {
	        	busOperatorRepository.deleteByEmail(email);
	        	busOperatorRepository.resetAutoIncrement();  // Reset auto-increment value

	            return true;
	        }
	        return false;
	}
	

}
