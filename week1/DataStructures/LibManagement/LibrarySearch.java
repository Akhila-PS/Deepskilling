// LibrarySearch.java
import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearch {

    // Linear search by title - O(n), no ordering required
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search by title - O(log n), requires books sorted by title
    public static Book binarySearchByTitle(Book[] sortedBooks, String title) {
        int low = 0, high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedBooks[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return sortedBooks[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B1", "Clean Code", "Robert C. Martin"),
            new Book("B2", "Effective Java", "Joshua Bloch"),
            new Book("B3", "Algorithms", "Robert Sedgewick"),
            new Book("B4", "Introduction to Algorithms", "Thomas H. Cormen")
        };

        Book result1 = linearSearchByTitle(books, "Effective Java");
        System.out.println("Linear search: " + result1);

        Book[] sortedByTitle = books.clone();
        Arrays.sort(sortedByTitle, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
        Book result2 = binarySearchByTitle(sortedByTitle, "Algorithms");
        System.out.println("Binary search: " + result2);
    }
}