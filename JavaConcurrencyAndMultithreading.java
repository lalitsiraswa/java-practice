class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Inside Thread1 : " + i);
        }
    }
}

public class JavaConcurrencyAndMultithreading {
    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        thread1.start();
    }
}
