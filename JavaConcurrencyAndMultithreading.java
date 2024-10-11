class Thread1 extends Thread {
    public Thread1(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is starting");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Inside " + Thread.currentThread() + " : " + i);
        }
        System.out.println(Thread.currentThread().getName() + " is exiting");
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is starting");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Inside " + Thread.currentThread() + " : " + i);
        }
        System.out.println(Thread.currentThread().getName() + " is exiting");
    }
}

class StackImpl {
    private int[] array;
    private int stackTop;
    Object lock1;
    Object lock2;

    public StackImpl(int capacity) {
        array = new int[capacity];
        stackTop = -1;
        lock1 = new Object();
        lock2 = new Object();
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }

    public boolean push(int element) {
        synchronized (lock1) {
            if (isFull())
                return false;
            ++stackTop;
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            array[stackTop] = element;
            return true;
        }
    }

    public int pop() {
        synchronized (lock1) {
            if (isEmpty())
                return Integer.MIN_VALUE;
            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            --stackTop;
            return obj;
        }
    }
}

public class JavaConcurrencyAndMultithreading {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is starting");
        // Thread thread1 = new Thread1("Thread-1");
        // thread1.setDaemon(true);
        // thread1.start();
        // ---------------------------------
        // Thread thread2 = new Thread(new Thread2(), "Thread-2");
        // Thread thread2 = new Thread(() -> {
        // System.out.println(Thread.currentThread().getName() + " is starting");
        // for (int i = 1; i <= 5; i++) {
        // System.out.println("Inside " + Thread.currentThread() + " : " + i);
        // }
        // System.out.println(Thread.currentThread().getName() + " is exiting");
        // }, "Thread-2");
        // thread2.start();
        // System.out.println(Thread.currentThread().getName() + " is exiting");
        // ---------------------------------
        // Synchronization Block Example
        StackImpl stack = new StackImpl(5);
        new Thread(() -> {
            int counter = 0;
            while (++counter <= 5) {
                System.out.println("Pushed : " + counter + " : " + stack.push(counter));
            }
        }, "Pusher").start();
        new Thread(() -> {
            int counter = 0;
            while (++counter <= 5) {
                System.out.println("Popped " + stack.pop());
            }
        }, "Popped").start();
        System.out.println(Thread.currentThread().getName() + " is exiting");

    }
}
