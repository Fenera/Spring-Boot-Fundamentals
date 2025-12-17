package com.application.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
public class StripePaymentService implements PaymentService {
    @Value("${stripe.apiURL}")
    private String apiURL;

    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;


    @Override
    public void processPayment(double amount){
        System.out.println("STRIPE");
        System.out.println("Amount: " + amount);

        System.out.println("Stripe api url: " + apiURL);
        System.out.println("Stripe enabled: " + enabled);
        System.out.println("Stripe supported currencies: " + supportedCurrencies);
    }
}
