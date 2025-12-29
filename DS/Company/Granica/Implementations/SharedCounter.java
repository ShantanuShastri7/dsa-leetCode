public class SharedCounterExecutor {

    public static class SharedCounter {
        private volatile int counter = 0;
        private final Lock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }

        public int get() {
            return counter;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SharedCounter counter = new SharedCounter();


        ExecutorService executor = Executors.newFixedThreadPool(2);


        executor.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });


        executor.submit(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

 
        executor.shutdown(); 

        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Expected: 20000");
            System.out.println("Actual:   " + counter.get());
        } else {
            System.out.println("Timed out!");
        }
    }
}