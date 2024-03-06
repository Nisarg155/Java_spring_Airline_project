package org.airplane_project.controller;

import org.airplane_project.entity.Flight_Route;
import org.airplane_project.services.AirplaneService;
import org.airplane_project.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class FlightRestController {


    private FlightService flightService;

    @Autowired
    public FlightRestController(FlightService FService) {
        flightService = FService;
    }
    @GetMapping("/flights")
    public List<Flight_Route> findAll(){
        return flightService.findALl();
    }

    @GetMapping("/flights/{id}")
    public Flight_Route findById(@PathVariable  int id){

        Flight_Route flight = flightService.findById(id);

        if (flight == null) {
            throw new RuntimeException("Flight not found : " + id);
        }

        return flight;
    }

    @PostMapping("/flights")
    public Flight_Route addFlightRoute(@RequestBody Flight_Route flight){
        flightService.save(flight);
        return flight;
    }


    @PutMapping("/flights")
    public Flight_Route updateFlightRoute(@RequestBody Flight_Route flight){
        flightService.save(flight);
        return flight;
    }

    @DeleteMapping("/flights/{id}")
    public String deleteFlightRoute(@PathVariable int id){
        Flight_Route flight = flightService.findById(id);
        if(flight == null){
            throw new RuntimeException("Flight not found : " + id);
        }
        flightService.deleteById(id);
        return "Deleted Flight id : " + id ;

    }


   // GET /api/flights/search?departureCity={departureCity}&destinationCity={destinationCity}&departureDate={departureDate}
}
