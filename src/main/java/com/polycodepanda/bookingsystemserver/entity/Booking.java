package com.polycodepanda.bookingsystemserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    private int booking_id;
    private int user_id;
    private int instrument_id;
    private Date booking_from;
    private Date booking_to;
}
