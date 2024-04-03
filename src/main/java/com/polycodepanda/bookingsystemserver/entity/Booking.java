package com.polycodepanda.bookingsystemserver.entity;

import jakarta.persistence.*;
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

    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    @Column(name = "user_id")
    private int userId;
    private int instrument_id;
    private Date booking_from;
    private Date booking_to;
    private String booking_status;
    private String picked;
}
