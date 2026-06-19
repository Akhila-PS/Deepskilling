/**
 * Computer.java
 *
 * Product class with several attributes, some required and some
 * optional. A static nested Builder handles step-by-step
 * construction so callers never use a long constructor argument list.
 */
public class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String gpu;        // optional
    private final boolean bluetooth; // optional

    // Private constructor - only the Builder is allowed to create a Computer
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.bluetooth = builder.bluetooth;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu
                + ", RAM=" + ram
                + ", Storage=" + storage
                + ", GPU=" + (gpu == null ? "None" : gpu)
                + ", Bluetooth=" + bluetooth + "]";
    }

    /**
     * Static nested Builder class. Each setter returns "this" so calls
     * can be chained fluently, ending with build().
     */
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private boolean bluetooth;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}