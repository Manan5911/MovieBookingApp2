package com.msba.springbootmoviebookingapplication2.service.impl;

import com.msba.springbootmoviebookingapplication2.dto.TheatreDto;
import com.msba.springbootmoviebookingapplication2.entity.Theatre;
import com.msba.springbootmoviebookingapplication2.exception.ResourceNotFoundException;
import com.msba.springbootmoviebookingapplication2.repository.TheatreRepository;
import com.msba.springbootmoviebookingapplication2.service.TheatreService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    private TheatreRepository theatreRepository;

    private ModelMapper mapper;

    public TheatreServiceImpl(TheatreRepository theatreRepository, ModelMapper mapper) {
        this.theatreRepository = theatreRepository;
        this.mapper = mapper;
    }
    @Override
    public TheatreDto createTheatre(TheatreDto theatreDto) {
        Theatre theatre = mapToEntity(theatreDto);
        Theatre newTheatre = theatreRepository.save(theatre);
        return mapToDto(newTheatre);
    }

    @Override
    public List<TheatreDto> getAllTheatres() {
        List<Theatre> theatres = theatreRepository.findAll();
        return theatres.stream().map(theatre -> mapToDto(theatre)).collect(Collectors.toList());
    }

    @Override
    public TheatreDto getTheatreById(long id) {
        Theatre theatre = theatreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Theatre", "id", id));
        return mapToDto(theatre);
    }

    @Override
    public void deleteTheatreById(long id) {
        Theatre theatre = theatreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Theatre", "id", id));
        theatreRepository.delete(theatre);
    }

    @Override
    public TheatreDto findByTheatreName(String theatreName) {
        Theatre theatre = theatreRepository.findByTheatreName(theatreName);
        return mapToDto(theatre);
    }

    @Override
    public TheatreDto findByTheatreNameAndTheatreCity(String theatreName, String theatreCity) {
        Theatre theatre = theatreRepository.findByTheatreNameAndTheatreCity(theatreName, theatreCity);
        return mapToDto(theatre);
    }

    private TheatreDto mapToDto(Theatre theatre){
        TheatreDto theatreDto = mapper.map(theatre, TheatreDto.class);
        return theatreDto;
    }

    private Theatre mapToEntity(TheatreDto theatreDto){
        Theatre theatre = mapper.map(theatreDto, Theatre.class);
        return theatre;
    }

}
