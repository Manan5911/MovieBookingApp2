package com.msba.springbootmoviebookingapplication2.controller;

import com.msba.springbootmoviebookingapplication2.dto.ScreeningDto;
import com.msba.springbootmoviebookingapplication2.service.ScreeningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    private ScreeningService screeningService;


    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @PostMapping("/theatreId/{id}/screeningId/{screeningId}")
    public ResponseEntity<ScreeningDto> createScreening(@RequestBody ScreeningDto screeningDto, @PathVariable(name = "id") long theatreId, @PathVariable(name = "screeningId") long screeningId){
        return new ResponseEntity<>(screeningService.createScreening(screeningDto, theatreId, screeningId), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ScreeningDto> getAllScreenings(){
        return screeningService.getAllScreenings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreeningDto> getScreeningById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(screeningService.getScreeningById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScreening(@PathVariable(name="id") long id){
        screeningService.deleteScreeningById(id);
        return new ResponseEntity<>("Screening entity deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/{name}/{id}/{date}")
    public ResponseEntity<ScreeningDto> getScreeningByMovieNameAndTheatreIdAndScreeningDate(@PathVariable(name = "name")String movieName, @PathVariable(name = "id") long theatreId, @PathVariable(name = "date")String screeningDate){
        return ResponseEntity.ok(screeningService.findByMovieNameAndTheatreIdAndScreeningDate(movieName,theatreId,screeningDate));
    }

    @GetMapping("/screeningDate/{date}")
    public ResponseEntity<ScreeningDto> getScreeningByScreeningDate(@PathVariable(name = "date") String screeningDate){
        return ResponseEntity.ok(screeningService.findByScreeningDate(screeningDate));
    }
}
