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

Using Constructor Injection: 

Use Open-Closed Principle:
Create the interface by:
Go to class you want to implement the interface
Refactor -> Extract/Introduce -> Interface -> Select methods for interface to define
Pass 

Using Setter Injection:
Similar to Constructor Injection -> just with a setter
Use only for optional dependencies (The OrderService should work without the setter injection)
Injecting PaymentService into a setter is not recommended
=======================================================
IOC (inversion of control) Container:
responsible for managing the lifecycle of objects called beans and their dependencies

To allow Spring to manage objects:
i.e.:        
ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
var orderService = context.getBean(OrderService.class);
orderService.placeOrder();

Go to the class that creates the object (OrderService) and annotate it with @Component (or @Service -> alias for Component)

@Component -> general purpose
@Service -> classes that contain business logic
@Repository -> classes that interact with a db
@Controller -> marking classes as controllers for handling web requests

You should place the @Autowired annotation on the single constructor you want Spring to use for dependency injection (for single constructor classes, no need to use @Autowired)
If you have optional variables, use setter injection instead of multiple constructors

If you have multiple instances of an interface/abstract class (Stripe & PayPal),
control the bean selection by using @Primary and @Qualifier
In the example code, paypal is the payment service used for OrderService while Stripe is the general payment service for everything else

@Qualifier and Dependency Injection
The core idea of loose coupling in software design is that a component should depend on an abstraction (like an interface) rather than a concrete implementation.
Loose Coupling (via Interface): The component that uses the dependency (the client) doesn't create the dependency itself or manage its lifecycle. Instead, the framework (like Spring) injects the dependency at runtime (Inversion of Control). The client interacts with the dependency through an interface, making it agnostic to the underlying concrete class.