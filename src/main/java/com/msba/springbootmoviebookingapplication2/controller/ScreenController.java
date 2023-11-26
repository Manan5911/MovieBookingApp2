package com.msba.springbootmoviebookingapplication2.controller;

import com.msba.springbootmoviebookingapplication2.dto.ScreenDto;
import com.msba.springbootmoviebookingapplication2.service.ScreenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {

    private ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping("/theatreId/{id}")
    public ResponseEntity<ScreenDto> createScreen(@RequestBody ScreenDto screenDto, @PathVariable(name="id") long theatreId){
        return new ResponseEntity<>(screenService.createScreen(screenDto, theatreId), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ScreenDto> getAllScreens(){
        return screenService.getAllScreens();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreenDto> getScreenById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(screenService.getScreenById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScreen(@PathVariable(name="id") long id){
        screenService.deleteScreenById(id);
        return new ResponseEntity<>("Screen entity deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/theatreId/{id}")
    public List<ScreenDto> getByTheatreId(@PathVariable(name="id") long id){
        return screenService.findByTheatreId(id);
    }
}
