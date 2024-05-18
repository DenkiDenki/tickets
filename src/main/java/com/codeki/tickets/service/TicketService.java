package com.codeki.tickets.service;

import com.codeki.tickets.model.FlightDto;
import com.codeki.tickets.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TicketService {
    @Autowired
    FlightClient flightClient;
    private final List<Ticket> tickets = new ArrayList<>();
    public List<Ticket> getAllTickets() {
        return tickets;
    }

    public Ticket addTicket(Ticket ticket, long id) {
        // Obtener el vuelo correspondiente por su ID
        FlightDto flightToTicket = (FlightDto) flightClient.getFlightById(id)
                .orElseThrow(() -> new RuntimeException("Flight with id " + id + " not found"));

        // Establecer el vuelo
        ticket.setFlight(flightToTicket);

        //Agregar ticket al array
        tickets.add(ticket);

        //devolver ticket
        return ticket;
    }
}
