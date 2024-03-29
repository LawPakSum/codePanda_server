package com.polycodepanda.bookingsystemserver.controller;

import com.polycodepanda.bookingsystemserver.entity.Booking;
import com.polycodepanda.bookingsystemserver.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

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
}
