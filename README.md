Dependency Injection:

Manages how dependencies interact
Avoids services from being tightly coupled

Think of OrderService ---> PaymentService (interface)
StripeService and PayPalService (classes) implement PaymentService

Inject a dependency into a class

public class OrderService {
public void placeOrder(){

        // here OrderService is tightly couped with StripePaymentService()
        // cannot test OrderService in isolation
        // changing to a different provider -> changing OrderService class
        var paymentService = new StripePaymentService();
        paymentService.processPayment(10.0);
    }
}

