package com.polycodepanda.bookingsystemserver.service;

import com.polycodepanda.bookingsystemserver.entity.Record;
import com.polycodepanda.bookingsystemserver.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public Record saveRecord(Record record){
        return recordRepository.save(record);
    }

    public List<Record> saveRecords(List<Record> records){
        return recordRepository.saveAll(records);
    }

    public Record getRecord(int id){
        return recordRepository.findById(id).orElse(null);
    }

    public List<Record> getRecords(){
        return recordRepository.findAll();
    }

    public Record updateRecord(Record record){
        Record targetRecord = recordRepository.findById(record.getRecord_id()).orElse(null);
        targetRecord.setGet_time(record.getGet_time());
        targetRecord.setReturn_time(record.getReturn_time());
        targetRecord.setReturned(record.getReturned());
        return recordRepository.save(targetRecord);
    }

    public String deleteRecord(int id){
        recordRepository.deleteById(id);
        return "record id: "+ id + " deleted.";
    }
}
