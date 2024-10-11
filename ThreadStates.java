public class ThreadStates {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Thread Started");
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Thread Started");
            try {
                Thread.sleep(4);
                for (int i = 10000; i > 0; i--)
                    ;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Thread Exiting");
        }, "States");
        thread1.start();
        while (true) {
            Thread.State state = thread1.getState();
            System.out.println(state);
            if (state == Thread.State.TERMINATED)
                break;
        }
        System.out.println(Thread.currentThread().getName() + " Thread Exiting");
    }
}
