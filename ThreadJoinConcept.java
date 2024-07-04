public class ThreadJoinConcept {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " -- START");
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "Our Thread");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -- END");
    }
}
