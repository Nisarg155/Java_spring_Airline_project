package org.airplane_project.controller;


import org.airplane_project.entity.Flight_Route;
import org.airplane_project.entity.Ticket;
import org.airplane_project.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    @GetMapping("/tickets/passengerByName/{name}")
    public List<Ticket> getTicketsByPassengerName(@PathVariable String name)
    {
        List<Ticket> ticketsByPassengerName = ticketService.getTicketsByPassengerName(name);
        return ticketsByPassengerName ;
    }

    @GetMapping("/tickets/count/{flightRouteId}")
    public List<Ticket> countTicketsByFlightRouteId(@PathVariable int flightRouteId) {
        return ticketService.countTicketsByFlightRouteId(flightRouteId);
    }

    @GetMapping("/tickets/total_count/{flightRouteId}")
    public long count(@PathVariable int flightRouteId) {
        return ticketService.count(flightRouteId);
    }


//UI-MVC Thymleaf

//    @GetMapping("/bookTicket")
//    public String showBookTicketForm(Model model) {
//        model.addAttribute("ticket", new Ticket());
//        return "bookTicket";
//    }
//
//    @PostMapping("/bookTicket")
//    public String bookTicket(@ModelAttribute("ticket") Ticket ticket) {
//        ticketService.bookTicket(ticket);
//        // Redirect to confirmation page or another page after booking
//        return "redirect:/confirmation";
//    }


    //  POST /api/tickets/purchase
}
