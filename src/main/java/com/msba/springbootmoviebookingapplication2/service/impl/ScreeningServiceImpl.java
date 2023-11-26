package com.msba.springbootmoviebookingapplication2.service.impl;

import com.msba.springbootmoviebookingapplication2.dto.ScreeningDto;
import com.msba.springbootmoviebookingapplication2.entity.Screening;
import com.msba.springbootmoviebookingapplication2.exception.ResourceNotFoundException;
import com.msba.springbootmoviebookingapplication2.repository.ScreeningRepository;
import com.msba.springbootmoviebookingapplication2.service.ScreeningService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private ScreeningRepository screeningRepository;
    private TheatreServiceImpl theatreServiceImpl;
    private ScreenServiceImpl screenServiceImpl;
    private ModelMapper mapper;

    public ScreeningServiceImpl(ScreeningRepository screeningRepository, TheatreServiceImpl theatreServiceImpl, ScreenServiceImpl screenServiceImpl, ModelMapper mapper) {
        this.screeningRepository = screeningRepository;
        this.theatreServiceImpl = theatreServiceImpl;
        this.screenServiceImpl = screenServiceImpl;
        this.mapper = mapper;
    }

    @Override
    public ScreeningDto createScreening(ScreeningDto screeningDto, long theatreId, long screenId) {
        Screening screening = mapToEntity(screeningDto);
        screening.setTheatreId(theatreId);
        screening.setScreenId(screenId);
        Screening newScreening = screeningRepository.save(screening);
        return mapToDto(newScreening);
    }

    @Override
    public List<ScreeningDto> getAllScreenings() {
        List<Screening> screenings = screeningRepository.findAll();
        return screenings.stream().map(screening -> mapToDto(screening)).collect(Collectors.toList());
    }

    @Override
    public ScreeningDto getScreeningById(long id) {
        Screening screening = screeningRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Screening", "id", id));
        return mapToDto(screening);
    }

    @Override
    public void deleteScreeningById(long id) {
        Screening screening = screeningRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Screening", "id", id));
        screeningRepository.delete(screening);
    }

    @Override
    public ScreeningDto findByMovieNameAndTheatreIdAndScreeningDate(String movieName, long theatreId, String screeningDate) {
        Screening screening = screeningRepository.findByMovieNameAndTheatreIdAndScreeningDate(movieName, theatreId, screeningDate);
        return mapToDto(screening);
    }

    @Override
    public ScreeningDto findByScreeningDate(String screeningDate) {
        Screening screening = screeningRepository.findByScreeningDate(screeningDate);
        return mapToDto(screening);
    }

    private ScreeningDto mapToDto(Screening screening){
        ScreeningDto screeningDto = mapper.map(screening, ScreeningDto.class);
        return screeningDto;
    }

    private Screening mapToEntity(ScreeningDto screeningDto){
        Screening screening = mapper.map(screeningDto, Screening.class);
        return screening;
    }
}
