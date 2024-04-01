package com.polycodepanda.bookingsystemserver.controller;

import com.polycodepanda.bookingsystemserver.entity.*;
import com.polycodepanda.bookingsystemserver.entity.Record;
import com.polycodepanda.bookingsystemserver.service.BookingService;
import com.polycodepanda.bookingsystemserver.service.InstrumentService;
import com.polycodepanda.bookingsystemserver.service.RecordService;
import com.polycodepanda.bookingsystemserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class RecordController {

    @Autowired
    private RecordService recordService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private UserService userService;
    @Autowired
    private InstrumentService instrumentService;

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

    @GetMapping("/getRecordInfo")
    public List<BookingRecord> getRecordInfo(){
        List <BookingRecord> bookingRecords = new ArrayList<>();
        List <Record> records = recordService.getRecords();
        for(Record record: records){
            BookingRecord bookingRecord = new BookingRecord();
            Booking booking = bookingService.findBooking(record.getBooking_id());
            User user = userService.getUserById(booking.getUserId());
            Instrument instrument = instrumentService.getInstrumentByID(booking.getInstrument_id());
            bookingRecord.setRecord(record);
            bookingRecord.setBooking(booking);
            bookingRecord.setUser(user);
            bookingRecord.setInstrument(instrument);
            bookingRecords.add(bookingRecord);

        }
        return bookingRecords;
    }
}
