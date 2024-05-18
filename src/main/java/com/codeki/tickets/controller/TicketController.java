package com.codeki.tickets.controller;

import com.codeki.tickets.model.FlightDto;
import com.codeki.tickets.model.Ticket;
import com.codeki.tickets.service.FlightClient;
import com.codeki.tickets.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private FlightClient flightClient;

    @GetMapping("")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @PostMapping("/add/{id}")
    public Ticket addTicket(@RequestBody Ticket ticket, @PathVariable Long id){
        //System.out.println(ticket.toString());
        return ticketService.addTicket(ticket, id);
    }

    @GetMapping("/flights/")
    public List<FlightDto> getAllFlights(){
        return flightClient.getAllFlights();
    }

    @GetMapping("/flights/{id}")
    public Optional<FlightDto> findFlightById(@PathVariable Long id) {
        return flightClient.getFlightById(id);
    }
}
