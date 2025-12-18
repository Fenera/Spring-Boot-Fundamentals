package com.application.store;

public interface UserRepository {
    boolean save(User user);
    User findByEmail(String email);
}
