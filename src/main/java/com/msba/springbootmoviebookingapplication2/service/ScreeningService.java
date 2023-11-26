package com.msba.springbootmoviebookingapplication2.service;

import com.msba.springbootmoviebookingapplication2.dto.ScreeningDto;

import java.util.List;

public interface ScreeningService {
    ScreeningDto createScreening(ScreeningDto screeningDto, long theatreId, long screenId);
    List<ScreeningDto> getAllScreenings();
    ScreeningDto getScreeningById(long id);
    void deleteScreeningById(long id);
    ScreeningDto findByMovieNameAndTheatreIdAndScreeningDate(String movieName, long theatreId, String screeningDate);
    ScreeningDto findByScreeningDate(String screeningDate);
}
