package com.msba.springbootmoviebookingapplication2.dto;

import lombok.Data;

import java.util.Set;

@Data
public class TheatreDto {
    private Long theatreId;
    private String theatreName;
    private String theatreCity;
    private Set<ScreenDto> screens;
    private Set<ScreeningDto> screenings;
}
