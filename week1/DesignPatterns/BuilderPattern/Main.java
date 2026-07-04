/**
 * Main.java
 *
 * Demonstrates building different Computer configurations using the
 * Builder pattern, including a config that skips the optional fields.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Test ===\n");

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("512GB SSD")
                .build();

        Computer gamingPC = new Computer.Builder()
                .setCPU("AMD Ryzen 9")
                .setRAM("32GB")
                .setStorage("2TB NVMe SSD")
                .setGPU("NVIDIA RTX 4080")
                .setBluetooth(true)
                .build();

        System.out.println("Office configuration: " + officePC);
        System.out.println("Gaming configuration: " + gamingPC);

        System.out.println("\nSUCCESS: Two different Computer configurations were built.");
    }
}