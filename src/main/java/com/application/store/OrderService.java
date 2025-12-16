package com.application.store;

import org.springframework.core.annotation.Order;

public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    public OrderService(){}
    public void placeOrder(){

        // use instance of PaymentService to placeOrder
        // we didn't have to modify OrderService to use different service providers
        paymentService.processPayment(10.0);
    }
    // use setter injection
    public void setPaymentService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
}
