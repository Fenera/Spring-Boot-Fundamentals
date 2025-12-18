package com.application.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository rep;
    NotificationService notificationService;

    @Autowired
    public UserService(UserRepository rep,
                       NotificationService notificationService){
        this.rep = rep;
        this.notificationService = notificationService;
    }
    public void registerUser(User user){
        if(rep.save(user)) {
            notificationService.sendMessage("You are registered",
                    user.getEmail());
        } else{
            throw new IllegalArgumentException("User with email: " + user.getEmail() + " already exists");
        }
    }


}
