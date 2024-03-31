package com.polycodepanda.bookingsystemserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InstrumentBooking {
    private Booking booking;
    private Instrument instrument;
}
