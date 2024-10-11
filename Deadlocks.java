// A deadlock is a situation where a thred is waiting for an object lock that another thread holds, and this second thread is waiting for an object lock that the first thread holds. 
// Since each thread is waiting for the other thread to relinquish a lock, they both reamin forever in the Blocked-for-lock-acquisition state.
public class Deadlocks {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Started");
        String lock1 = "Lalit";
        String lock2 = "Siraswa";
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Started");
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " Lock1 Acquired");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " Lock2 Acquired");
                }
            }
            System.out.println(Thread.currentThread().getName() + " Exiting");
        }, "Thread-1");
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Started");
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " Lock2 Acquired");
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " Lock1 Acuired");
                }
            }
            System.out.println(Thread.currentThread().getName() + " Exiting");
        }, "Thread-2");
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName() + " Exiting");
    }
}
