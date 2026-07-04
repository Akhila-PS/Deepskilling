/**
 * PayPalGateway.java
 *
 * Adaptee. Another third-party-style gateway, with a different
 * method name and an extra "currency" parameter.
 */
public class PayPalGateway {
    public void sendPayPalPayment(double amount, String currency) {
        System.out.println("Sending " + amount + " " + currency + " through PayPal.");
    }
}