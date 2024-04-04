package com.polycodepanda.bookingsystemserver.entity;

import jakarta.persistence.Column;
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
@Table(name="User")
public class User {

    @Id
    private int user_id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_identity")
    private String userIdentity;
}
