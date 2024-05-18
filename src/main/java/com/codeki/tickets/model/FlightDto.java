package com.codeki.tickets.model;

import java.time.LocalDateTime;

public class FlightDto {
    private Long id;
    private String cod;
    private String origin;
    private String destiny;
    private LocalDateTime dateTimeDeparture;
    private LocalDateTime dateTimeArrival;
    private double convertedPrice;
    private String frequency;
    private String company;
}
