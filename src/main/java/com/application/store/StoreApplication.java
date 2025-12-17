package com.application.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        // assign the ApplicationContext (IoC container) to a variable
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        // retrieves a specific bean instance (object) from IoC container based on the name
        // get object managed by Spring
        var orderService = context.getBean(OrderService.class);
        // singleton scope
        var orderService2 = context.getBean(OrderService.class);
        orderService.placeOrder();

        context.close();
    }

}
