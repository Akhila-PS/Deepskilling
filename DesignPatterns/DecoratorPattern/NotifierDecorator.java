/**
 * NotifierDecorator.java
 *
 * Abstract decorator. Implements Notifier and holds a reference to
 * the wrapped Notifier, delegating to it before/after adding extra
 * behavior in subclasses.
 */
public abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}