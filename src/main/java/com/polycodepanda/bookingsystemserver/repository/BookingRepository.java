package com.polycodepanda.bookingsystemserver.repository;

import com.polycodepanda.bookingsystemserver.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
