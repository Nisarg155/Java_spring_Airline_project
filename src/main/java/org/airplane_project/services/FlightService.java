package org.airplane_project.services;

import org.airplane_project.DAO.AirplaneDAO;
import org.airplane_project.DAO.FlightDAO;
import org.airplane_project.entity.Flight_Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FlightService {

    private FlightDAO flightDAO;

    @Autowired
    public FlightService(FlightDAO theFlightDAO) {
        flightDAO = theFlightDAO;
    }

    @Transactional
    public  List<Flight_Route> findALl() {
        return flightDAO.findAll();
    }

    @Transactional
    public Flight_Route findById(int id) {
        return flightDAO.findById(id);
    }
    @Transactional
    public  void save(Flight_Route flight) {
        flightDAO.save(flight);
    }

    @Transactional
    public void deleteById(int id) {
        flightDAO.deleteById(id);
    }
}
