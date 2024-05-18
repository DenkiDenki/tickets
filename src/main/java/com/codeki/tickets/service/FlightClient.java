package com.codeki.tickets.service;

import com.codeki.tickets.model.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "flight-server")
public interface FlightClient {
    @GetMapping("/flights")
    List<FlightDto> getAllFlights();

    @GetMapping("/flights/{id}")
    Optional<FlightDto> getFlightById(Long id);
}
