/**
 * StripeAdapter.java
 *
 * Adapts StripeGateway's makeStripePayment(double) to the
 * PaymentProcessor.processPayment(double) interface.
 */
public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.makeStripePayment(amount);
    }
}