package com.application.store;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InMemoryUserRepository implements UserRepository{

    private final Map<String, User> map = new HashMap<>();

    public boolean save(User user){
        if(findByEmail(user.getEmail()) == null){
            map.put(user.getEmail(), user);
            return true;
        }
        return false;
    }

    public User findByEmail(String email){
        return map.get(email);
    }
}
