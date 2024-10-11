public class JoinThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Thread Started");
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
            System.out.println(Thread.currentThread().getName() + " Exiting");
        }, "Our Thread");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Thread Exiting");
    }
}
