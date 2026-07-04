/**
 * PayPalAdapter.java
 *
 * Adapts PayPalGateway's sendPayPalPayment(double, String) to the
 * PaymentProcessor.processPayment(double) interface.
 */
public class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayPalPayment(amount, "USD");
    }
}