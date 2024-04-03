package com.polycodepanda.bookingsystemserver.controller;

import com.polycodepanda.bookingsystemserver.entity.Booking;
import com.polycodepanda.bookingsystemserver.entity.Instrument;
import com.polycodepanda.bookingsystemserver.entity.InstrumentBooking;
import com.polycodepanda.bookingsystemserver.entity.User;
import com.polycodepanda.bookingsystemserver.service.BookingService;
import com.polycodepanda.bookingsystemserver.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private InstrumentService instrumentService;

    @PostMapping("/addBooking")
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.saveBooking(booking);
    }

    @PostMapping("/addBookings")
    public List<Booking> addBookings(@RequestBody List<Booking> bookings){
        return bookingService.saveBookings(bookings);
    }

    @GetMapping("/getBooking/{id}")
    public Booking getBooking(@PathVariable int id){
        return bookingService.findBooking(id);
    }

    @GetMapping("/getBookings")
    public List<Booking> getBookings(){
        return bookingService.findBookings();
    }

    @PutMapping("/updateBooking")
    public Booking updateBooking(@RequestBody Booking booking){
        return bookingService.updateBooking(booking);
    }

    @DeleteMapping("/deleteBooking")
    public String deleteBooking(@RequestBody int id){
        return bookingService.deleteBooking(id);
    }

    @PostMapping("/getBookingByUser")
    public List<InstrumentBooking> getUserBooking(@RequestBody User user){
        List<Booking> bookings = bookingService.findBookingByUser(user);
        List<InstrumentBooking> instrumentBookings= new ArrayList<>();
        for(Booking booking: bookings){
            InstrumentBooking instrumentBooking = new InstrumentBooking();
            instrumentBooking.setBooking(booking);
            System.out.println(booking.getInstrument_id());
            Instrument instrument = instrumentService.getInstrumentByID(booking.getInstrument_id());
            instrumentBooking.setInstrument(instrument);
            instrumentBookings.add(instrumentBooking);
        }
        return instrumentBookings;
    }

    @PostMapping("/cancelBooking")
    public Booking cancelBooking(@RequestBody Booking booking){
        return bookingService.cancelBooking(booking.getBooking_id());
    }
}
