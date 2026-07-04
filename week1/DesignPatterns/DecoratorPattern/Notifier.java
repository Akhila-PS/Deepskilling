/**
 * Notifier.java
 *
 * Component interface shared by the base notifier and every decorator,
 * so decorators can be stacked on top of one another transparently.
 */
public interface Notifier {
    void send(String message);
}