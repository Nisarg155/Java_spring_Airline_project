package org.airplane_project.services;

import org.airplane_project.DAO.AirplaneDAO;
import org.airplane_project.DAO.TicketDAO;
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
}