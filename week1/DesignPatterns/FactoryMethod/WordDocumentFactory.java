/**
 * WordDocumentFactory.java
 *
 * Concrete factory that produces WordDocument instances.
 */
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}