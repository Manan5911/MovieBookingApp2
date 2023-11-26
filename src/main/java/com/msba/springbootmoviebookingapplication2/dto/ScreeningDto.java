package com.msba.springbootmoviebookingapplication2.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ScreeningDto {
    private Long screeningId;
    private Long theatreId;
    private Long screenId;
    private String movieName;
    private Date screeningDate;
    private Long bookedTickets;
}
