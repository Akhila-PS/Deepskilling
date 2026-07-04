/**
 * PdfDocumentFactory.java
 *
 * Concrete factory that produces PdfDocument instances.
 */
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}