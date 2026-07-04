/**
 * Observer.java
 *
 * Interface implemented by every client that wants to be notified
 * of stock price changes.
 */
public interface Observer {
    void update(String stockSymbol, double price);
}