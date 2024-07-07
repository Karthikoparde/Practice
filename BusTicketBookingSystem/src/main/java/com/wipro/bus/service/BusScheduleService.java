package com.wipro.bus.service;

import com.wipro.bus.dto.BusSearchDTO;
import com.wipro.bus.entities.BusSchedule;
import java.util.List;
import java.util.Optional;

public interface BusScheduleService {
    
    BusSchedule createBusSchedule(BusSchedule busSchedule);
    
    List<BusSchedule> getAllBusSchedules();
    
    Optional<BusSchedule> getBusScheduleById(Long scheduleId);
    List<BusSchedule> searchBuses(BusSearchDTO busSearchDTO);
    
//    BusSchedule getScheduleByScheduleId(Long scheduleId);
   
}
