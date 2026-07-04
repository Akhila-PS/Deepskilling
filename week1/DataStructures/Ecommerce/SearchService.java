// SearchService.java
import java.util.Arrays;
import java.util.Comparator;

public class SearchService {

    // Linear Search: O(n) - works on unsorted array
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null; // not found
    }

    // Binary Search: O(log n) - requires array sorted by productName
    public static Product binarySearch(Product[] sortedProducts, String targetName) {
        int low = 0, high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedProducts[mid].getProductName().compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return sortedProducts[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // not found
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P003", "Yoga Mat", "Fitness"),
            new Product("P001", "Wireless Mouse", "Electronics"),
            new Product("P002", "Mechanical Keyboard", "Electronics"),
            new Product("P004", "Desk Lamp", "Home")
        };

        // Linear search works directly on the unsorted array
        Product found1 = linearSearch(products, "Desk Lamp");
        System.out.println("Linear search result: " + found1);

        // Binary search requires a sorted copy
        Product[] sorted = products.clone();
        Arrays.sort(sorted, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
        Product found2 = binarySearch(sorted, "Wireless Mouse");
        System.out.println("Binary search result: " + found2);
    }
}