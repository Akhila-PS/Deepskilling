// EmployeeArrayManager.java
import java.util.Arrays;

public class EmployeeArrayManager {
    private Employee[] employees;
    private int size; // number of employees currently stored

    public EmployeeArrayManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add - O(1) amortized (O(n) when the array must grow/resize)
    public boolean add(Employee employee) {
        if (size == employees.length) {
            employees = Arrays.copyOf(employees, employees.length * 2); // O(n) resize
        }
        employees[size++] = employee;
        return true;
    }

    // Search by employeeId - O(n)
    public Employee search(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse - O(n)
    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete by employeeId - O(n), shifts subsequent elements left
    public boolean delete(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1]; // shift left
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeArrayManager manager = new EmployeeArrayManager(4);
        manager.add(new Employee("E1", "Asha", "Developer", 65000));
        manager.add(new Employee("E2", "Ravi", "Manager", 85000));
        manager.add(new Employee("E3", "Mei", "Designer", 60000));

        manager.traverse();
        System.out.println("Found: " + manager.search("E2"));
        manager.delete("E1");
        System.out.println("After delete:");
        manager.traverse();
    }
}