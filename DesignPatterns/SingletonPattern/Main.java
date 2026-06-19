/**
 * Main.java
 *
 * Test class that verifies only one instance of Logger
 * is ever created and used across the application.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test ===\n");

        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Processing data.");

        Logger logger3 = Logger.getInstance();
        logger3.log("Application finished.");

        System.out.println();
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));
        System.out.println("Total logs recorded by the single instance: " + logger1.getLogCount());

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("\nSUCCESS: Only one instance of Logger exists.");
        } else {
            System.out.println("\nFAILURE: Multiple instances detected.");
        }
    }
}