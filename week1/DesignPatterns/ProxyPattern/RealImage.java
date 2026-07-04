/**
 * RealImage.java
 *
 * Real subject. Represents an image that is expensive to obtain
 * because it has to be fetched from a remote server.
 */
public class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading " + fileName + " from remote server...");
        System.out.println(fileName + " loaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}