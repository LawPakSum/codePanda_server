package com.polycodepanda.bookingsystemserver.controller;

import com.polycodepanda.bookingsystemserver.entity.*;
import com.polycodepanda.bookingsystemserver.entity.Record;
import com.polycodepanda.bookingsystemserver.service.BookingService;
import com.polycodepanda.bookingsystemserver.service.InstrumentService;
import com.polycodepanda.bookingsystemserver.service.RecordService;
import com.polycodepanda.bookingsystemserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Booking targetbooking = bookingService.findBooking(record.getBooking_id());
        targetbooking.setPicked("yes");
        bookingService.saveBooking(targetbooking);
        Record targetRecord = recordService.saveRecord(record);
        instrumentService.changeStoring(targetbooking.getInstrument_id());
        return targetRecord;
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
    public Record updateReturn(@RequestBody Record record){
        return recordService.updateReturn(record.getRecord_id());
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

    @PostMapping("/checkBorrowAllow")
    public Boolean checkBorrowAllow(@RequestBody User user) {
        List <Record> records = recordService.getRecords();
        List <Booking> bookings = bookingService.findBookingByUser(user);
        List <Record> notReturned = new ArrayList<>();
        for (Record r : records){
            if(r.getReturned().equals("no")){
                notReturned.add(r);
            }
        }
        for (Record r: notReturned){
            for (Booking b: bookings){
                if (r.getBooking_id() == b.getBooking_id()){
                    return true;
                }
            }
        }
        return false;
    }
}
