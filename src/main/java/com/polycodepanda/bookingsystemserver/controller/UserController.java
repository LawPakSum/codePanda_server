package com.polycodepanda.bookingsystemserver.controller;

import com.polycodepanda.bookingsystemserver.entity.User;
import com.polycodepanda.bookingsystemserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return service.saveUsers(users);
    }

    @GetMapping("/getUsers")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/getUser/{id}")
    public User findUser(@PathVariable int id){
        return service.getUserById(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody int id){
        return service.deleteUser(id);
    }

    @PostMapping("/verifyLogin")
    public  String verifyLogin(@RequestBody User user){
        return service.verifyLogin(user);
    }
}
