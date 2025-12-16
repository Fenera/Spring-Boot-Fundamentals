package com.application.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        var orderService = new OrderService();
        // using setter injection to pass in payment service
        orderService.setPaymentService(new PayPalPaymentService());
        orderService.placeOrder();
    }

}
