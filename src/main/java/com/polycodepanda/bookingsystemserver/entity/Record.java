package com.polycodepanda.bookingsystemserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="RECORD")
public class Record {

    @Id
    private int record_id;
    private int booking_id;
    private LocalDateTime get_time;
    private LocalDateTime return_time;
    private String returned;
}
