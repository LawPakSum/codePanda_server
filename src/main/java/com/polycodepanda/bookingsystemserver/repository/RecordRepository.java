package com.polycodepanda.bookingsystemserver.repository;

import com.polycodepanda.bookingsystemserver.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}
