public class ThreadStateDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " -- START");
        Thread thread = new Thread(() -> {
            try {
                // System.out.println(Thread.currentThread().getName() + " : " +
                // Thread.currentThread().getState());
                Thread.sleep(50);
                // System.out.println(Thread.currentThread().getName() + " : " +
                // Thread.currentThread().getState());
                for (int i = 10000; i > 0; i--)
                    ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "STATES");

        thread.start();

        while (true) {
            Thread.State state = thread.getState();
            System.out.println(thread.getName() + " : " + state);
            if (state == Thread.State.TERMINATED)
                break;
        }
        System.out.println(Thread.currentThread().getName() + " -- END");
    }
}
