package com.polycodepanda.bookingsystemserver.service;

import com.polycodepanda.bookingsystemserver.entity.Booking;
import com.polycodepanda.bookingsystemserver.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public List<Booking> saveBookings(List<Booking> bookings){
        return bookingRepository.saveAll(bookings);
    }

    public Booking findBooking(int id){
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> findBookings(){
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Booking booking){
        Booking targetBooking = bookingRepository.findById(booking.getBooking_id()).orElse(null);
        targetBooking.setBooking_from(booking.getBooking_from());
        targetBooking.setBooking_to(booking.getBooking_to());
        return bookingRepository.save(targetBooking);
    }

    public String deleteBooking(int id){
        bookingRepository.deleteById(id);
        return "Booking id:" + id +" is deleted.";
    }
}
