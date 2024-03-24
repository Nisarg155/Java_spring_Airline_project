package org.airplane_project.services;

import org.airplane_project.DAO.AirplaneDAO;
import org.airplane_project.DAO.TicketDAO;
import org.airplane_project.entity.Flight_Route;
import org.airplane_project.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TicketService {

    private TicketDAO ticketDAO;

    @Autowired
    public TicketService(TicketDAO theTicketDAO) {
        ticketDAO = theTicketDAO;
    }

    @Transactional
    public List<Ticket> findALl() {
        return ticketDAO.findAll();
    }

    @Transactional
    public Ticket findById(int id) {
        return ticketDAO.findById(id);
    }

    @Transactional
    public void save(Ticket ticket) {
        ticketDAO.save(ticket);
    }



    @Transactional
    public void deleteById(int id) {
        ticketDAO.deleteById(id);
    }



    public List<Ticket> getTicketsByPassengerId(int PId) {
        return ticketDAO.getTicketsByPassengerId(PId);
    }

    public List<Ticket> countTicketsByFlightRouteId(int flightRouteId) {
        return ticketDAO.countTicketsByFlightRouteId(flightRouteId);

    }

    public long count(int flightRouteId) {
        return ticketDAO.count(flightRouteId);
    }

    public List<Ticket> getTicketsByPassengerName(String name) {
        return ticketDAO.getTicketsByPassengerName(name);
    }

    //UI-MVC Thymleaf

//    public void bookTicket(Ticket ticket) {
//        ticketDAO.saveTicket(ticket);
//    }
}
