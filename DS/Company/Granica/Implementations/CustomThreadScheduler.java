public class CustomScheduler {
    private final BlockingQueue<Runnable> taskQueue;
    
    private final Thread[] workerThreads;
    
    private volatile boolean isRunning = true;

    public CustomScheduler(int numberOfWorkers) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workerThreads = new Thread[numberOfWorkers];

        for (int i = 0; i < numberOfWorkers; i++) {
            workerThreads[i] = new Worker("Worker-" + i);
            workerThreads[i].start();
        }
    }

    // method to submit tasks (Producer)
    public void submit(Runnable task) {
        if (!isRunning) {
            throw new IllegalStateException("Scheduler is stopped.");
        }
        try {
            taskQueue.put(task); // Blocks if queue is full (optional capacity)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // 3. The Worker Logic (Consumer)
    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (isRunning || !taskQueue.isEmpty()) {
                try {
                    // .take() BLOCKS if the queue is empty.
                    // This is crucial: it puts the thread to sleep until a task arrives.
                    Runnable task = taskQueue.take();
                    
                    System.out.println(getName() + " started a task.");
                    task.run(); 
                    System.out.println(getName() + " finished a task.");
                    
                } catch (InterruptedException e) {
                    if (!isRunning) break; 
                }
            }
        }
    }

    public void shutdown() {
        isRunning = false;
        for (Thread t : workerThreads) {
            t.interrupt();
        }
    }

    // --- Main Method for Testing ---
    public static void main(String[] args) {
        CustomScheduler scheduler = new CustomScheduler(2); // 2 Workers

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            scheduler.submit(() -> {
                try {
                    Thread.sleep(1000); // Simulate work
                    System.out.println("Task " + taskId + " completed.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
    }
}