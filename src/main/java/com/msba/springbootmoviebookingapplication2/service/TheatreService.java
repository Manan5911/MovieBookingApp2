package com.msba.springbootmoviebookingapplication2.service;

import com.msba.springbootmoviebookingapplication2.dto.TheatreDto;

import java.util.List;

public interface TheatreService {
    TheatreDto createTheatre(TheatreDto theatreDto);
    List<TheatreDto> getAllTheatres();
    TheatreDto getTheatreById(long id);
    void deleteTheatreById(long id);
    TheatreDto findByTheatreName(String theatreName);
    TheatreDto findByTheatreNameAndTheatreCity(String theatreName, String theatreCity);
}
