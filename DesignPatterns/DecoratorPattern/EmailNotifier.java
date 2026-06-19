/**
 * EmailNotifier.java
 *
 * Concrete component providing the base notification behavior
 * (sending an email). Decorators add channels on top of this.
 */
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}