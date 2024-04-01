package com.polycodepanda.bookingsystemserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookingRecord {

    private Record record;
    private Booking booking;
    private User user;
    private Instrument instrument;
}
