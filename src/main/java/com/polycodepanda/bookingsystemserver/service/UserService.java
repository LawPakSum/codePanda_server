package com.polycodepanda.bookingsystemserver.service;

import com.polycodepanda.bookingsystemserver.entity.User;
import com.polycodepanda.bookingsystemserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user){
        User targetUser = userRepository.findById(user.getUser_id()).orElse(null);
        targetUser.setUser_name(user.getUser_name());
        targetUser.setUser_identity(user.getUser_identity());
        targetUser.setUser_password(user.getUser_password());
        return userRepository.save(targetUser);
    }

    public String deleteUser(int id){
        String name = getUserById(id).getUser_name();
        userRepository.deleteById(id);
        return "user id:" + id + ", user name: "+ name + "is deleted.";
    }
}
