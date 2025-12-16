package com.application.store;

public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    public void placeOrder(){

        // use instance of PaymentService to placeOrder
        // we didn't have to modify OrderService to use different service providers
        paymentService.processPayment(10.0);
    }
}
