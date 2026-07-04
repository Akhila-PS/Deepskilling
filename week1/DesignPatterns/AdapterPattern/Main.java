/**
 * Main.java
 *
 * Demonstrates processing payments through two different,
 * incompatible gateways using a single, uniform interface.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Test ===\n");

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(49.99);

        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        payPalProcessor.processPayment(25.00);

        System.out.println("\nSUCCESS: Both gateways were used through the common PaymentProcessor interface.");
    }
}