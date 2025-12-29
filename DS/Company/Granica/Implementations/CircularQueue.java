import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

    // --- Internal Storage (Ring Buffer) ---
    private final Object[] items;
    private int putIndex = 0;
    private int takeIndex = 0;
    private int count = 0;

    // --- Concurrency Controls ---
    private final ReentrantLock lock = new ReentrantLock();
    // REAL FIELD: Condition for waiting puts (Producers wait here)
    private final Condition notFull = lock.newCondition(); 
    // REAL FIELD: Condition for waiting takes (Consumers wait here)
    private final Condition notEmpty = lock.newCondition();

    // Constructor
    public MyBlockingQueue(int capacity) {
        this.items = new Object[capacity];
    }

    // ==========================================
    // YOUR REQUESTED METHODS (The Core Logic)
    // ==========================================

    // THE PRODUCER
    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            // 1. IF FULL: Go to the "Waiting for Space" room
            // (Using while loop to guard against spurious wakeups)
            while (count == items.length) {
                System.out.println("  -> Queue FULL. Producer is waiting...");
                notFull.await();
            }

            // 2. INSERT the item (Internal Ring Buffer logic)
            enqueue(e);

            // 3. ALERT the "Waiting for Data" room
            // "Hey Cashiers, there is food now!"
            notEmpty.signal();
            
        } finally {
            lock.unlock();
        }
    }

    // THE CONSUMER
    public E take() throws InterruptedException {
        lock.lock();
        try {
            // 1. IF EMPTY: Go to the "Waiting for Data" room
            while (count == 0) {
                System.out.println("  -> Queue EMPTY. Consumer is waiting...");
                notEmpty.await();
            }

            // 2. REMOVE the item (Internal Ring Buffer logic)
            E x = dequeue();

            // 3. ALERT the "Waiting for Space" room
            // "Hey Cooks, there is free space on the slide now!"
            notFull.signal();

            return x;
        } finally {
            lock.unlock();
        }
    }

    // ==========================================
    // HELPER METHODS (The Ring Buffer Math)
    // ==========================================
    
    private void enqueue(E x) {
        items[putIndex] = x;
        // Wrap around logic (Ring Buffer)
        putIndex = (putIndex + 1) % items.length; 
        count++;
        System.out.println("Produced: " + x + " | Count: " + count);
    }

    private E dequeue() {
        @SuppressWarnings("unchecked")
        E x = (E) items[takeIndex];
        items[takeIndex] = null; // Help Garbage Collector
        // Wrap around logic (Ring Buffer)
        takeIndex = (takeIndex + 1) % items.length;
        count--;
        System.out.println("Consumed: " + x + " | Count: " + count);
        return x;
    }

    // ==========================================
    // MAIN METHOD (To Run and Test it)
    // ==========================================
    public static void main(String[] args) {
        // Create a queue with size 3
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(3);

        // 1. Create the Cook (Producer)
        Thread cook = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put("Burger #" + i);
                    Thread.sleep(200); // Cook is fast (0.2s)
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 2. Create the Cashier (Consumer)
        Thread cashier = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(1000); // Cashier is SLOW (1.0s)
                    queue.take();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("--- Starting Shop (Queue Size: 3) ---");
        cook.start();
        cashier.start();
    }
}