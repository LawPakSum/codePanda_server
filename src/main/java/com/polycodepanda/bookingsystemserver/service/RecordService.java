package com.polycodepanda.bookingsystemserver.service;

import com.polycodepanda.bookingsystemserver.entity.Instrument;
import com.polycodepanda.bookingsystemserver.entity.Record;
import com.polycodepanda.bookingsystemserver.entity.User;
import com.polycodepanda.bookingsystemserver.repository.BookingRepository;
import com.polycodepanda.bookingsystemserver.repository.InstrumentRepository;
import com.polycodepanda.bookingsystemserver.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private InstrumentRepository instrumentRepository;

    public Record saveRecord(Record record){
        System.out.println(record.getBooking_id());
        record.setGet_time(LocalDateTime.now());
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

        Instrument targetInstrument = instrumentRepository.findById((bookingRepository.findById(targetRecord.getBooking_id()).orElse(null)).getUserId()).orElse(null);
        targetInstrument.setInstrument_borrow_status("out");

        return recordRepository.save(targetRecord);
    }

    public String deleteRecord(int id){
        recordRepository.deleteById(id);
        return "record id: "+ id + " deleted.";
    }

    public Record updateReturn(int id){
        Record targetRecord = recordRepository.findById(id).orElse(null);
        targetRecord.setReturn_time(LocalDateTime.now());
        targetRecord.setReturned("yes");
        Instrument targetInstrument = instrumentRepository.findById((bookingRepository.findById(targetRecord.getBooking_id()).orElse(null)).getUserId()).orElse(null);
        targetInstrument.setInstrument_borrow_status("storing");
        instrumentRepository.save(targetInstrument);
        return recordRepository.save(targetRecord);
    }

}
