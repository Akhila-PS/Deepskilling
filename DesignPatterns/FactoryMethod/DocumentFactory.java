/**
 * DocumentFactory.java
 *
 * Abstract creator class declaring the factory method that
 * subclasses override to produce a specific Document type.
 */
public abstract class DocumentFactory {
    public abstract Document createDocument();
}