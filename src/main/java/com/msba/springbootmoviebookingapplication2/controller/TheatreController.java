package com.msba.springbootmoviebookingapplication2.controller;

import com.msba.springbootmoviebookingapplication2.dto.TheatreDto;
import com.msba.springbootmoviebookingapplication2.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController {
    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    public ResponseEntity<TheatreDto> createTheatre(@RequestBody TheatreDto theatreDto){
        return new ResponseEntity<>(theatreService.createTheatre(theatreDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<TheatreDto> getAllTheatres(){
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TheatreDto> getTheatreById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(theatreService.getTheatreById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTheatre(@PathVariable(name="id") long id){
        theatreService.deleteTheatreById(id);
        return new ResponseEntity<>("Theatre entity deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TheatreDto> getTheatreByName(@PathVariable(name="name") String theatreName){
        return ResponseEntity.ok(theatreService.findByTheatreName(theatreName));
    }

    @GetMapping("/{name}/{city}")
    public ResponseEntity<TheatreDto> getTheatreByNameAndCity(@PathVariable(name="name") String theatreName, @PathVariable(name = "city") String theatreCity){
        return ResponseEntity.ok(theatreService.findByTheatreNameAndTheatreCity(theatreName, theatreCity));
    }
}
