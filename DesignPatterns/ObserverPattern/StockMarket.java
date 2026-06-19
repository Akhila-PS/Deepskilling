import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String symbol;
    private double price;

    @Override
    public void registerObserver(Observer o) { observers.add(o); }

    @Override
    public void deregisterObserver(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) o.update(symbol, price);
    }

    public void setPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        notifyObservers();
    }
}