package com.polycodepanda.bookingsystemserver.controller;

import com.polycodepanda.bookingsystemserver.entity.Record;
import com.polycodepanda.bookingsystemserver.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("/addRecord")
    public Record addRecord(@RequestBody Record record){
        return recordService.saveRecord(record);
    }

    @PostMapping("/addRecords")
    public List<Record> addRecords(@RequestBody List<Record> records){
        return recordService.saveRecords(records);
    }

    @GetMapping("/getRecord/{id}")
    public Record findRecord(@PathVariable int id){
        return recordService.getRecord(id);
    }

    @GetMapping("/getRecords")
    public List<Record> findRecords(){
        return recordService.getRecords();
    }

    @PutMapping("/updateRecord")
    public Record updateRecord(@RequestBody Record record){
        return recordService.updateRecord(record);
    }

    @DeleteMapping("/deleteRecord")
    public String deleteRecord(@RequestBody int id){
        return recordService.deleteRecord(id);
    }

    @PostMapping("/updateReturn")
    public Record updateReturn(@RequestBody int id){
        return recordService.updateReturn(id);
    }
}
