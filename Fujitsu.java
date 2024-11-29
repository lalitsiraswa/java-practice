class NumberPrinter {
    private int currentNumber = 1;
    private final int MAX_NUMBER = 10;

    public synchronized void printNumbers() {
        while (currentNumber <= MAX_NUMBER) {
            System.out.println(Thread.currentThread().getName() + " : " + currentNumber);
            currentNumber++;
            // Notify the other thread that it can take its turn
            notify();
            try {
                // Wait if we haven't reached the maximum number, allowing the other thread to
                // proceed
                if (currentNumber <= MAX_NUMBER) {
                    wait();
                }
            } catch (InterruptedException e) {
                // Reset interrupted status
                Thread.currentThread().interrupt();
            }
        }
    }
}

// In the code example provided, we’re using a method reference
// (printer::printNumbers) to specify the task for each thread. The Thread
// constructor accepts either a Runnable object or a lambda expression (or
// method reference) that matches the Runnable functional interface, which has a
// single run() method.
public class Fujitsu {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        // Create two threads that will share the same NumberPrinter instance
        Thread t1 = new Thread(printer::printNumbers, "Thread-1");
        Thread t2 = new Thread(printer::printNumbers, "Thread-2");
        // Start both threads
        t1.start();
        t2.start();

    }
}
