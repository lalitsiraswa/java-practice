class Thread1 extends Thread {
    public Thread1(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            // System.out.println("Inside " + Thread.currentThread().getName() + " : " +
            // i);}
            System.out.println("Inside " + Thread.currentThread() + " : " + i);
        }
    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            // System.out.println("Inside " + Thread.currentThread().getName() + " : " +
            // i);}
            System.out.println("Inside " + Thread.currentThread() + " : " + i);
        }
    }
}

public class ThreadImplementation {
    public static void main(String[] args) {
        System.out.println("Main is starting...");
        Thread thread1 = new Thread1("Thread-1");
        // thread1.setDaemon(true);
        thread1.start();

        Thread thread2 = new Thread(new Thread2(), "Thread-2");
        thread2.start();
        System.out.println("Main is exiting...");
    }
}
