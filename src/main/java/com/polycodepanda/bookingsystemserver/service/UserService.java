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
        targetUser.setUserName(user.getUserName());
        targetUser.setUserIdentity(user.getUserIdentity());
        targetUser.setUserPassword(user.getUserPassword());
        return userRepository.save(targetUser);
    }

    public String deleteUser(int id){
        String name = getUserById(id).getUserName();
        userRepository.deleteById(id);
        return "user id:" + id + ", user name: "+ name + "is deleted.";
    }

    public String verifyLogin(User user){
        List<User> targetUsers = userRepository.findByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
        if(targetUsers.size() == 1){
            return targetUsers.get(0).getUserIdentity()+"-"+targetUsers.get(0).getUser_id();
        }
        else {
            return "invalid";
        }
    }
}
