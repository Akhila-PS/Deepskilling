public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setPrice("AAPL", 195.32);
        market.setPrice("GOOG", 2840.15);

        market.deregisterObserver(web);
        System.out.println("-- WebApp deregistered --");
        market.setPrice("AAPL", 196.00);
    }
}