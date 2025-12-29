class MyCircularQueue {
    
    private int[] data;
    private int front;
    private int rear;
    private int capacity;

    // Constructor
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        
        // Initialize pointers to -1 to denote an empty queue
        this.front = -1;
        this.rear = -1;
    }
    
    // Insert an element into the circular queue
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        // If queue is currently empty, we must set the front pointer to 0
        if (isEmpty()) {
            this.front = 0;
        }
        
        // Circular increment of rear pointer
        this.rear = (this.rear + 1) % this.capacity;
        this.data[this.rear] = value;
        
        return true;
    }
    
    // Delete an element from the circular queue
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        
        // If front == rear, only one element exists.
        // Reset the queue to empty state (-1) after removing it.
        if (this.front == this.rear) {
            this.front = -1;
            this.rear = -1;
        } else {
            // Circular increment of front pointer
            this.front = (this.front + 1) % this.capacity;
        }
        
        return true;
    }
    
    // Get the front item from the queue
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.data[this.front];
    }
    
    // Get the last item from the queue
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return this.data[this.rear];
    }
    
    // Checks whether the circular queue is empty
    public boolean isEmpty() {
        return this.front == -1;
    }
    
    // Checks whether the circular queue is full
    public boolean isFull() {
        // Logic: The next position of rear is equal to front
        return ((this.rear + 1) % this.capacity) == this.front;
    }
}