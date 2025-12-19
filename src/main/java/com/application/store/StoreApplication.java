package com.application.store;

import com.application.store.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        // assign the ApplicationContext (IoC container) to a variable
//        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//
//
//        context.close();

        Category category = Category.builder()
                .id((byte) 1)
                .name("Bottled Water")
                .build();

        category.addProduct("Aquafina", new BigDecimal(1.09));

        System.out.println(category);
    }
}
