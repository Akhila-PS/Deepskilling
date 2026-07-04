/**
 * StripeGateway.java
 *
 * Adaptee. A third-party-style gateway with its own method name
 * and signature that does NOT match PaymentProcessor.
 */
public class StripeGateway {
    public void makeStripePayment(double amountInDollars) {
        System.out.println("Processing $" + amountInDollars + " through Stripe.");
    }
}