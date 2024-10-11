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

public class JavaConcurrencyAndMultithreading {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is starting");
        Thread thread1 = new Thread1("Thread-1");
        // thread1.setDaemon(true);
        thread1.start();
        System.out.println(Thread.currentThread().getName() + " is exiting");
    }
}
