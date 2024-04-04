package com.polycodepanda.bookingsystemserver.service;

import com.polycodepanda.bookingsystemserver.entity.Instrument;
import com.polycodepanda.bookingsystemserver.repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository repository;

    public Instrument saveInstrument(Instrument instrument){
        return repository.save(instrument);
    }

    public List<Instrument> saveInstruments(List<Instrument> instruments){
        return repository.saveAll(instruments);
    }

    public List<Instrument> getInstruments(){
        return repository.findAll();
    }

    public Instrument getInstrumentByID(int id){
        return repository.findById(id).orElse(null);
    }

    public String deleteInstrument(int id){
        repository.deleteById(id);
        return "Instrument id:" + id + "was deleted.";
    }

    public Instrument updateInstrument(Instrument instrument){
        Instrument targetInstrument = repository.findById(instrument.getInstrument_id()).orElse(null);
        targetInstrument.setInstrument_name(instrument.getInstrument_name());
        targetInstrument.setInstrument_classification(instrument.getInstrument_classification());
        targetInstrument.setInstrument_playstyle(instrument.getInstrument_playstyle());
        targetInstrument.setInstrument_condition(instrument.getInstrument_condition());
        targetInstrument.setInstrument_borrow_status(instrument.getInstrument_borrow_status());
        targetInstrument.setInstrument_remark(instrument.getInstrument_remark());
        return repository.save(targetInstrument);
    }

    public String suspendInstrument(@RequestBody Instrument instrument){
        Instrument targetInstrument = repository.findById(instrument.getInstrument_id()).orElse(null);
        if(targetInstrument.getInstrument_remark()!="suspend")
            targetInstrument.setInstrument_remark("suspend");
        else{
            targetInstrument.setInstrument_remark("");
        }
        repository.save(targetInstrument);
        return targetInstrument.getInstrument_id() + "suspended";
    }
}
