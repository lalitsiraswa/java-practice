class PrintSeries implements Runnable {
    // Integer i = 1;
    static Integer i = 1;

    @Override
    public void run() {
        synchronized (i) {
            while (i <= 10) {
                System.out.println(i++);
            }
        }
    }
}

public class Fujitsu {
    public static void main(String[] args) {
        // PrintSeries printSeries = new PrintSeries();
        // Thread t1 = new Thread(printSeries);
        // Thread t2 = new Thread(printSeries);
        // ------------------------------------------
        PrintSeries printSeries1 = new PrintSeries();
        PrintSeries printSeries2 = new PrintSeries();
        Thread t1 = new Thread(printSeries1);
        Thread t2 = new Thread(printSeries2);
        // ------------------------------------------
        t1.start();
        t2.start();
    }
}
