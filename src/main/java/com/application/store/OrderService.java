package com.application.store;

public class OrderService {
    public void placeOrder(){

        // here OrderService is tightly couped with StripePaymentService()
        // cannot test OrderService in isolation
        // changing to a different provider (i.e. PayPal) -> changing OrderService class
        var paymentService = new StripePaymentService();
        paymentService.processPayment(10.0);
    }
}
