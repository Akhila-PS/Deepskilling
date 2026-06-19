/**
 * Logger.java
 *
 * Singleton class that ensures only one Logger instance exists
 * throughout the application lifecycle, giving consistent logging.
 */
public class Logger {

    // The single, private instance of the class
    private static Logger instance;

    // Keeps track of how many messages this Logger has written
    private int logCount;

    // Private constructor - prevents instantiation from outside the class
    private Logger() {
        logCount = 0;
        System.out.println("Logger instance created.");
    }

    // Public static method that returns the single instance,
    // creating it the first time it is requested (lazy initialization).
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Writes a log message and increments the log counter
    public void log(String message) {
        logCount++;
        System.out.println("[LOG #" + logCount + "] " + message);
    }

    public int getLogCount() {
        return logCount;
    }
}