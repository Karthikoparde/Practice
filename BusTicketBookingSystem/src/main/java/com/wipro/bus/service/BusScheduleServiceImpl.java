package com.wipro.bus.service;

import com.wipro.bus.dto.BusSearchDTO;
import com.wipro.bus.entities.BusSchedule;
import com.wipro.bus.entities.User;
import com.wipro.bus.repository.BusScheduleRepository;
import com.wipro.bus.service.BusScheduleService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {

    @Autowired
    private BusScheduleRepository busScheduleRepository;
    

    @Override
    public BusSchedule createBusSchedule(BusSchedule busSchedule) {
        return busScheduleRepository.save(busSchedule);
    }
    
    @Override
    public List<BusSchedule> getAllBusSchedules() {
        return busScheduleRepository.findAll();
    }
    
    @Override
    public Optional<BusSchedule> getBusScheduleById(Long scheduleId) {
        return busScheduleRepository.findById(scheduleId);
    }
    
    @Override
    public List<BusSchedule> searchBuses(BusSearchDTO busSearchDTO) {
        return busScheduleRepository.findByOriginAndDestination(busSearchDTO.getOrigin(), busSearchDTO.getDestination());
    }

//	@Override
//	public BusSchedule getScheduleByScheduleId(Long scheduleId) {
//		return busScheduleRepository.findByBusScheduleId(scheduleId);
//	}


    
    
}
