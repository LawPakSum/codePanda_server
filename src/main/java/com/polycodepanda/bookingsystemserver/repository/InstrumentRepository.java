package com.polycodepanda.bookingsystemserver.repository;

import com.polycodepanda.bookingsystemserver.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {
}
