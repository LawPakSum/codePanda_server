package com.polycodepanda.bookingsystemserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INSTRUMENT")
public class Instrument {

    @Id
    private int instrument_id;
    private String instrument_name;
    private String instrument_classification;
    private String instrument_playstyle;
    private String instrument_borrow_status;
    private String instrument_condition;
    private String instrument_remark;
}
