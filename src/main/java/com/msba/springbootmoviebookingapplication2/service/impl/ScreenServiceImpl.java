package com.msba.springbootmoviebookingapplication2.service.impl;

import com.msba.springbootmoviebookingapplication2.dto.ScreenDto;
import com.msba.springbootmoviebookingapplication2.entity.Screen;
import com.msba.springbootmoviebookingapplication2.exception.ResourceNotFoundException;
import com.msba.springbootmoviebookingapplication2.repository.ScreenRepository;
import com.msba.springbootmoviebookingapplication2.service.ScreenService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImpl implements ScreenService {

    private ScreenRepository screenRepository;
    private TheatreServiceImpl theatreServiceImpl;
    private ModelMapper mapper;

    public ScreenServiceImpl(ScreenRepository screenRepository, ModelMapper mapper, TheatreServiceImpl theatreServiceImpl) {
        this.screenRepository = screenRepository;
        this.theatreServiceImpl = theatreServiceImpl;
        this.mapper = mapper;
    }
    @Override
    public ScreenDto createScreen(ScreenDto screenDto, long theatreId) {
        Screen screen = mapToEntity(screenDto);
        screen.setTheatreId(theatreId);
        Screen newScreen = screenRepository.save(screen);
        return mapToDto(newScreen);
    }

    @Override
    public List<ScreenDto> getAllScreens() {
        List<Screen> screens = screenRepository.findAll();
        return screens.stream().map(screen -> mapToDto(screen)).collect(Collectors.toList());
    }

    @Override
    public ScreenDto getScreenById(long id) {
        Screen screen = screenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Screen", "id", id));
        return mapToDto(screen);
    }

    @Override
    public void deleteScreenById(long id) {
        Screen screen = screenRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Screen", "id", id));
        screenRepository.delete(screen);
    }

    @Override
    public List<ScreenDto> findByTheatreId(long theatreId) {
        List<Screen> screens = screenRepository.findByTheatreId(theatreId);
        return screens.stream().map(screen -> mapToDto(screen)).collect(Collectors.toList());
    }

    private ScreenDto mapToDto(Screen screen){
        ScreenDto screenDto = mapper.map(screen, ScreenDto.class);
        return screenDto;
    }

    private Screen mapToEntity(ScreenDto screenDto){
        Screen screen = mapper.map(screenDto, Screen.class);
        return screen;
    }
}
