package com.polycodepanda.bookingsystemserver.controller;

import com.polycodepanda.bookingsystemserver.entity.Instrument;
import com.polycodepanda.bookingsystemserver.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class InstrumentController {

    @Autowired
    private InstrumentService service;

    @PostMapping("/addInstrument")
    public Instrument addInstrument(@RequestBody Instrument instrument){
        return service.saveInstrument(instrument);
    }

    @PostMapping("/addInstruments")
    public List<Instrument> addInstruments(@RequestBody List<Instrument> instruments){
        return service.saveInstruments(instruments);
    }

    @GetMapping("/getInstruments")
    public List<Instrument> findAllInstruments(){
        return service.getInstruments();
    }

    @GetMapping("/getInstrument/{id}")
    public Instrument findInstrument(@PathVariable int id){
        return service.getInstrumentByID(id);
    }

    @PutMapping("/updateInstrument")
    public Instrument updateInstrument(@RequestBody Instrument instrument){
        return service.updateInstrument(instrument);
    }

    @DeleteMapping("/deleteInstrument")
    public String deleteInstrument(@RequestBody int id){
        return service.deleteInstrument(id);
    }

}
