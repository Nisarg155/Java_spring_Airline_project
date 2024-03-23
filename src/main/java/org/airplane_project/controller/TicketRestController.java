package org.airplane_project.controller;


import org.airplane_project.entity.Flight_Route;
import org.airplane_project.entity.Ticket;
import org.airplane_project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketRestController {



    private TicketService ticketService;

    @Autowired
    public TicketRestController(TicketService TService) {
        ticketService = TService;
    }

    @GetMapping("/tickets")
    public List<Ticket> findAll(){
        return ticketService.findALl();
    }

    @GetMapping("/tickets/{id}")
    public Ticket findById(@PathVariable int id){

        Ticket ticket = ticketService.findById(id);

        if (ticket == null) {
            throw new RuntimeException("Ticket not found : " + id);
        }

        return ticket;
    }

    @PostMapping("/tickets")
    public Ticket addTicket(@RequestBody Ticket ticket){
        ticketService.save(ticket);
        return ticket;
    }


    @PutMapping("/tickets")
    public Ticket updateTicket(@RequestBody Ticket ticket){
        ticketService.save(ticket);
        return ticket;
    }

    @DeleteMapping("/tickets/{id}")
    public String deleteTicket(@PathVariable int id){
        Ticket ticket = ticketService.findById(id);
        if(ticket == null){
            throw new RuntimeException("Ticket not found : " + id);
        }
        ticketService.deleteById(id);
        return "Deleted Ticket id : " + id ;

    }


    @GetMapping("/tickets/passenger/{PId}")
    public List<Ticket> getTicketsByPassengerId(@PathVariable int PId)
    {
        List<Ticket> ticketsByPassengerId = ticketService.getTicketsByPassengerId(PId);
        return ticketsByPassengerId ;
    }

    @GetMapping("/tickets/count/{flightRouteId}")
    public List<Ticket> countTicketsByFlightRouteId(@PathVariable int flightRouteId) {
        return ticketService.countTicketsByFlightRouteId(flightRouteId);
    }
    //  POST /api/tickets/purchase
}
