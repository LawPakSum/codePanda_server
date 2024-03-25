package com.polycodepanda.bookingsystemserver.repository;

import com.polycodepanda.bookingsystemserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
