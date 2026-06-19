/**
 * Main.java
 *
 * Demonstrates creating different document types through their
 * respective factories, without the client code needing to know
 * the concrete document classes.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Test ===\n");

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();

        System.out.println();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();

        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();

        System.out.println("\nSUCCESS: Each factory created the correct document type.");
    }
}