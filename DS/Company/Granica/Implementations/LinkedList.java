public class LinkedList {

    Node head;
    Node tail;
    int size; 

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void insertAtHead(int value) {
        Node newHead = new Node(value, head);
        head = newHead;

        if (tail == null) 
            tail = head;

        size++;
    }

    void insertAtTail(int value) {
        Node newTail = new Node(value, null);

        if (tail == null) { 
            // empty list
            head = newTail;
            tail = newTail;
        } else {
            tail.next = newTail;
            tail = newTail;
        }

        size++;
    }

    void insertAtIndex(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            insertAtHead(value);
            return;
        }

        if (index == size) {
            insertAtTail(value);
            return;
        }

        int currentIndex = 0;
        Node prev = null;
        Node current = head;

        while (currentIndex < index) {
            prev = current;
            current = current.next;
            currentIndex++;
        }

        Node toInsert = new Node(value, current);
        prev.next = toInsert;

        size++;
    }

    void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
            if (head == null) tail = null; // list becomes empty
            size--;
            return;
        }

        int currentIndex = 0;
        Node prev = null;
        Node current = head;

        while (currentIndex < index) {
            prev = current;
            current = current.next;
            currentIndex++;
        }

        prev.next = current.next;

        if (index == size - 1) { 
            // deleting last element
            tail = prev;
        }

        size--;
    }

    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        Node current = head;

        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        return current.value;
    }

    int size() {
        return size;
    }

    public class Node {
        int value;
        Node next;

        public Node() {}

        public Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }
    }
}
