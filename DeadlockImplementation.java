public class DeadlockImplementation {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " -- START");
        String lock1 = "Lalit";
        String lock2 = "Siraswa";
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Lock Acquired!");
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Lock Acquired!");
                }
            }
        }, "Thread-2");

        thread1.start();
        thread2.start();

        while (true) {
            Thread.State thread1State = thread1.getState();
            Thread.State thread2State = thread2.getState();
            System.out.println(thread1.getName() + " : " + thread1State);
            System.out.println(thread2.getName() + " : " + thread2State);
            if (thread1State == Thread.State.TERMINATED && thread2State == Thread.State.TERMINATED)
                break;
        }
        System.out.println(Thread.currentThread().getName() + " -- END");
    }
}
