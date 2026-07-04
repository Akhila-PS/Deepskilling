// OrderSorter.java
public class OrderSorter {

    // Bubble Sort by totalPrice - O(n^2)
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // already sorted
        }
    }

    // Quick Sort by totalPrice - O(n log n) average
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] bubbleData = {
            new Order("O1", "Alice", 250.00),
            new Order("O2", "Bob", 75.50),
            new Order("O3", "Charlie", 410.25),
            new Order("O4", "Dana", 12.00)
        };
        bubbleSort(bubbleData);
        System.out.println("Bubble sorted:");
        for (Order o : bubbleData) System.out.println(o);

        Order[] quickData = {
            new Order("O5", "Eve", 99.99),
            new Order("O6", "Frank", 5.00),
            new Order("O7", "Grace", 320.10),
            new Order("O8", "Heidi", 150.00)
        };
        quickSort(quickData, 0, quickData.length - 1);
        System.out.println("Quick sorted:");
        for (Order o : quickData) System.out.println(o);
    }
}