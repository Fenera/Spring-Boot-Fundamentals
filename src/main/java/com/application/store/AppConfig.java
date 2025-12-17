package com.application.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

// manually create beans instead of using annotation (@Service)
@Configuration
public class AppConfig {
    @Value("${payment.service}")
    private String paymentService;
    @Bean
    public PaymentService stripe(){
        // if .... return stripe else ...
        // more control logic over bean creation
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PayPalPaymentService();
    }
    @Bean
    //@Scope("prototype") creates multiple instances
    @Scope("singleton") // default scope
    // others are request, session
    public OrderService orderService(){
        if(paymentService.equalsIgnoreCase("paypal")) return new OrderService(paypal());
        return new OrderService(stripe());
    }
}
