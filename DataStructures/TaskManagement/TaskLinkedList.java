// TaskLinkedList.java
public class TaskLinkedList {

    private static class Node {
        Task task;
        Node next;
        Node(Task task) { this.task = task; }
    }

    private Node head;
    private Node tail;
    private int size;

    // Add at the end - O(1) because we keep a tail reference
    public void add(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Search by taskId - O(n)
    public Task search(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse - O(n)
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete by taskId - O(n), must walk to find the node and its predecessor
    public boolean delete(String taskId) {
        if (head == null) return false;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return true;
        }

        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                prev.next = current.next;
                if (current == tail) tail = prev;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public int size() { return size; }

    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();
        list.add(new Task("T1", "Design schema", "PENDING"));
        list.add(new Task("T2", "Write API", "IN_PROGRESS"));
        list.add(new Task("T3", "Write tests", "PENDING"));

        list.traverse();
        System.out.println("Found: " + list.search("T2"));
        list.delete("T1");
        System.out.println("After delete:");
        list.traverse();
    }
}