package com.wipro.bus.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.bus.entities.Administrator;
import com.wipro.bus.entities.BusOperator;
import com.wipro.bus.entities.User;
import com.wipro.bus.repository.AdministratorRepository;
import com.wipro.bus.repository.BusOperatorRepository;
import com.wipro.bus.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BusOperatorRepository busOperatorRepository;
    
    public AdministratorServiceImpl(AdministratorRepository administratorRepository,
                                    BusOperatorRepository busOperatorRepository) {
        this.administratorRepository = administratorRepository;
        this.busOperatorRepository = busOperatorRepository;
    }

    @Override
    public Administrator registerAdministrator(Administrator administrator) {
        if (administratorRepository.findByEmail(administrator.getEmail()) != null) {
            throw new RuntimeException("Administrator already exists with this email");
        }
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator loginAdministrator(String email, String password) {
        Administrator administrator = administratorRepository.findByEmail(email);
        if (administrator != null && administrator.getPassword().equals(password)) {
            return administrator;
        }
        throw new RuntimeException("Invalid email or password");
    }

    @Override
    public BusOperator addBusOperator(BusOperator busOperator) {
        return busOperatorRepository.save(busOperator);
    }
    
//    @Override
//    public void deleteBusOperator(Long busOperatorId) {
//        BusOperatorRepository.deleteById(busOperatorId);
//    }
    
    @Transactional
	@Override
	public boolean deleteBusOperator(String email) {
		// TODO Auto-generated method stub
		 Optional<BusOperator> busOperatorOptional = busOperatorRepository.deleteByEmail(email);
	        if (busOperatorOptional.isPresent()) {
	            busOperatorRepository.deleteByEmail(email);
	            busOperatorRepository.resetAutoIncrement();  // Reset auto-increment value

	            return true;
	        }
	        return false;
	}
    
    @Transactional
	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		 Optional<User> userOptional = userRepository.deleteByEmail(email);
	        if (userOptional.isPresent()) {
	            userRepository.deleteByEmail(email);
	            userRepository.resetAutoIncrement();  // Reset auto-increment value

	            return true;
	        }
	        return false;
	}
}
