class Foo {
    AtomicInteger atomicInt;
    public Foo() {
        atomicInt = new AtomicInteger(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while(atomicInt.get()!=1){

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomicInt.compareAndSet(1,2);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(atomicInt.get()!=2){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        atomicInt.compareAndSet(2,3);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(atomicInt.get()!=3){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        atomicInt.compareAndSet(3,4);
    }
}