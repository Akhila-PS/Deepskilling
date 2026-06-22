// InventoryManager.java
import java.util.HashMap;
import java.util.Map;
 
public class InventoryManager {
    // HashMap chosen for O(1) average add/update/delete/search by productId
    private final Map<String, Product> inventory = new HashMap<>();
 
    // Add a new product - O(1) average
    public boolean addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            return false; // product already exists
        }
        inventory.put(product.getProductId(), product);
        return true;
    }
 
    // Update an existing product's quantity/price - O(1) average
    public boolean updateProduct(String productId, int newQuantity, double newPrice) {
        Product existing = inventory.get(productId);
        if (existing == null) return false;
        existing.setQuantity(newQuantity);
        existing.setPrice(newPrice);
        return true;
    }
 
    // Delete a product - O(1) average
    public boolean deleteProduct(String productId) {
        return inventory.remove(productId) != null;
    }
// Search a product - O(1) average
    public Product getProduct(String productId) {
        return inventory.get(productId);
    }
 
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.addProduct(new Product("P001", "Wireless Mouse", 150, 19.99));
        manager.addProduct(new Product("P002", "Mechanical Keyboard", 80, 49.99));
 
        System.out.println(manager.getProduct("P001"));
        manager.updateProduct("P001", 140, 17.99);
        System.out.println(manager.getProduct("P001"));
        manager.deleteProduct("P002");
        System.out.println("P002 found after delete: " + (manager.getProduct("P002") != null));
    }
}
