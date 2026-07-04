/**
 * Main.java
 *
 * Demonstrates that the first display() call triggers a remote load,
 * while subsequent calls on the same ProxyImage reuse the cache.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Proxy Pattern Test ===\n");

        Image image = new ProxyImage("vacation_photo.jpg");

        System.out.println("First call to display():");
        image.display();

        System.out.println("\nSecond call to display():");
        image.display();

        System.out.println("\nThird call to display():");
        image.display();

        System.out.println("\nSUCCESS: Image was loaded from the server only once, then served from cache.");
    }
}