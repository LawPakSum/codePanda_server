package com.polycodepanda.bookingsystemserver.repository;

import com.polycodepanda.bookingsystemserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUserNameAndUserPassword(String userName, String userPassword);
}
