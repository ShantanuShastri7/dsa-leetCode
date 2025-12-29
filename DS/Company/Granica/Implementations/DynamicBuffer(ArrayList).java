import java.util.Arrays;

public class DynamicBuffer<E> {

    // Internal Array (Not fixed! It will get swapped out)
    private Object[] data;
    
    // How many items we currently have
    private int size = 0;
    
    // The current physical size of the array in RAM
    private int capacity;

    public DynamicBuffer(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = new Object[capacity];
    }

    // ==========================================
    // 1. THE ADD LOGIC (The "Amortized" O(1))
    // ==========================================
    public void add(E element) {
        // CHECK: Is the bucket full?
        if (size == capacity) {
            resize(); // The expensive part!
        }

        data[size] = element;
        size++;
    }

    // ==========================================
    // 2. THE RESIZE LOGIC (The Hidden Cost)
    // ==========================================
    private void resize() {
        // Strategy: Double the size (2x Growth Factor)
        int newCapacity = capacity * 2;
        
        System.out.println("\n[!] BUFFER FULL (Size: " + size + ")");
        System.out.println("[!] Resizing from " + capacity + " to " + newCapacity);
        System.out.println("[!] Copying " + size + " items... (Expensive Operation)");

        // A. Allocate new memory block
        Object[] newData = new Object[newCapacity];

        // B. COPY everything over (O(n) operation)
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        // C. Point to the new array and trash the old one
        this.data = newData;
        this.capacity = newCapacity;
    }

    // ==========================================
    // 3. THE REMOVE LOGIC (The Shift Cost)
    // ==========================================
    public void removeAt(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        System.out.println("\nRemoving item at index " + index + " (" + data[index] + ")");
        
        // We have to SHIFT everything to the left to close the gap
        // Unlike Ring Buffer, we cannot leave a hole.
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        // Clear the last item (help Garbage Collector)
        data[size - 1] = null;
        size--;
    }

    public E get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        return (E) data[index];
    }

    public int size() {
        return size;
    }

    public void printBuffer() {
        System.out.print("Buffer: [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("] (Capacity: " + capacity + ")");
    }

    // ==========================================
    // MAIN TEST
    // ==========================================
    public static void main(String[] args) {
        // Start with a TINY capacity of 2
        DynamicBuffer<String> buffer = new DynamicBuffer<>(2);

        buffer.add("A");
        buffer.add("B");
        buffer.printBuffer();

        // This next add will trigger a RESIZE
        buffer.add("C"); 
        buffer.printBuffer();

        buffer.add("D");
        // This next add will trigger ANOTHER RESIZE (4 -> 8)
        buffer.add("E");
        buffer.printBuffer();

        // Demonstrate the slow remove (Shifting)
        buffer.removeAt(0); // Remove "A"
        buffer.printBuffer();
    }
}