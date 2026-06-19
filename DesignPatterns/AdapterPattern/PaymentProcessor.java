/**
 * PaymentProcessor.java
 *
 * Target interface that the rest of the application depends on.
 * Every payment gateway must be reachable through this interface.
 */
public interface PaymentProcessor {
    void processPayment(double amount);
}