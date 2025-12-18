package com.application.store;

public class User {
    private int id;
    private String email;
    private String password;
    private String name;

    User(int id, String email, String password, String name){
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
}
