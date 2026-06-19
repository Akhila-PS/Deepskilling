/**
 * ProxyImage.java
 *
 * Proxy. Holds a reference to a RealImage but only creates it (and
 * pays the remote-loading cost) the first time display() is called.
 * After that, the already-loaded RealImage is reused as a cache.
 */
public class ProxyImage implements Image {
    private RealImage realImage; // null until first use - lazy initialization
    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // expensive load happens once
        } else {
            System.out.println(fileName + " served from cache (no reload).");
        }
        realImage.display();
    }
}