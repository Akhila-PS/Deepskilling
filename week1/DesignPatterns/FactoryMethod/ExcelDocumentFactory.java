/**
 * ExcelDocumentFactory.java
 *
 * Concrete factory that produces ExcelDocument instances.
 */
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}