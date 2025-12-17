package com.application.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("Order Service created");
    }

    public OrderService(){}

    @PostConstruct
    public void init(){
        // this method will be called after a Bean of OrderService is created & initialized (constructor called)
        System.out.println("Order Service Construct"); // post construct message

    }
    @PreDestroy
    public void cleanup() {
       System.out.println("OrderService PreDestroy");
    }
    public void placeOrder(){

        // use instance of PaymentService to placeOrder
        // we didn't have to modify OrderService to use different service providers
        paymentService.processPayment(10.0);
    }
}
