/**
 * Main.java
 *
 * Demonstrates sending a notification through multiple channels by
 * stacking decorators on top of a base EmailNotifier.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Test ===\n");

        System.out.println("-- Email only --");
        Notifier emailOnly = new EmailNotifier();
        emailOnly.send("Server CPU usage is above 90%.");

        System.out.println("\n-- Email + SMS --");
        Notifier emailAndSms = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSms.send("Deployment finished successfully.");

        System.out.println("\n-- Email + SMS + Slack --");
        Notifier allChannels = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        allChannels.send("Production incident detected!");

        System.out.println("\nSUCCESS: Channels were added dynamically without changing EmailNotifier.");
    }
}