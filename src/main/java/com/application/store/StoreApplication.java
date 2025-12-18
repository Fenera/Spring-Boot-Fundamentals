package com.application.store;

import com.application.store.entities.Address;
import com.application.store.entities.User;
import com.application.store.entities.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        // assign the ApplicationContext (IoC container) to a variable
//        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//
//
//        context.close();

        var user = User.builder()
                .name("John")
                .password("password")
                .email("email")
                .build();


        user.addTag("tag1");


        System.out.println(user);

    }
}
