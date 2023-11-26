package com.msba.springbootmoviebookingapplication2.service;

import com.msba.springbootmoviebookingapplication2.dto.ScreenDto;

import java.util.List;

public interface ScreenService {
    ScreenDto createScreen(ScreenDto screenDto, long theatreId);
    List<ScreenDto> getAllScreens();
    ScreenDto getScreenById(long id);
    void deleteScreenById(long id);
    List<ScreenDto> findByTheatreId(long theatreId);
}
