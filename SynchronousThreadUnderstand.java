class StackCls {
    private int[] array;
    private int stackTop;
    Object lock1, lock2;

    public StackCls(int capacity) {
        array = new int[capacity];
        stackTop = -1;
        lock1 = new Object();
        lock2 = new Object();
    }

    public synchronized boolean push(int element) {
        // synchronized (lock1) {
        // When we use 'synchronized' function the compiler create the below structure
        // and in in the 'synchronized' block the locak will be 'this' Object
        // synchronized (this) {
        if (isFull())
            return false;
        ++stackTop;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        array[stackTop] = element;
        return true;
        // }
        // }
    }

    public synchronized int pop() {
        // synchronized (lock2) {
        // synchronized (lock1) {
        // When we use 'synchronized' function the compiler create the below structure
        // and in in the 'synchronized' block the locak will be 'this' Object
        // synchronized (this) {
        if (isEmpty())
            return Integer.MIN_VALUE;
        int obj = array[stackTop];
        array[stackTop] = Integer.MIN_VALUE;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        --stackTop;
        return obj;
        // }
        // }
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop >= array.length - 1;
    }
}

public class SynchronousThreadUnderstand {
    public static void main(String[] args) {
        StackCls stack = new StackCls(10);

        new Thread(() -> {
            int counter = 0;
            while (++counter <= 10) {
                System.out.println(Thread.currentThread().getName() + ", " + counter + " : " + stack.push(counter * 5));
            }
        }, "Pusher").start();

        new Thread(() -> {
            
            int counter = 0;
            while (++counter <= 10) {
                System.out.println(Thread.currentThread().getName() + ", " + counter + " : " + stack.pop());
            }
        }, "Popper").start();
    }
}
