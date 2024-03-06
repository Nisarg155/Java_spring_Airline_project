package org.airplane_project.services;

import org.airplane_project.DAO.AirplaneDAO;
import org.airplane_project.DAO.PassengerDAO;
import org.airplane_project.entity.Flight_Route;
import org.airplane_project.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PassengerService {

    private PassengerDAO passengerDAO;

    @Autowired
    public PassengerService(PassengerDAO thePassengerDAO) {
        passengerDAO = thePassengerDAO;
    }

    @Transactional
    public List<Passenger> findALl() {
        return passengerDAO.findAll();

    }

    @Transactional
    public Passenger findById(int id) {
        return passengerDAO.findById(id);

    }

    @Transactional
    public void save(Passenger psngr) {
        passengerDAO.save(psngr);
    }

    @Transactional
    public void deleteById(int id) {
        passengerDAO.deleteById(id);
    }
}