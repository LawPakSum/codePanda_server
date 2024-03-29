package com.polycodepanda.bookingsystemserver.controller;

import com.polycodepanda.bookingsystemserver.entity.Record;
import com.polycodepanda.bookingsystemserver.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;

    public Record addRecord(Record record){
        return recordService.saveRecord(record);
    }


    public List<Record> addRecords(List<Record> records){
        return recordService.saveRecords(records);
    }


    public Record findRecord(int id){
        return recordService.getRecord(id);
    }


    public List<Record> findRecords(){
        return recordService.getRecords();
    }


    public Record updateRecord(Record record){
        return recordService.updateRecord(record);
    }


    public String deleteRecord(int id){
        return recordService.deleteRecord(id);
    }
}
