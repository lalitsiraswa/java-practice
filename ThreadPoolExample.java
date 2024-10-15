// Java program to illustrate  
// ThreadPool 
// Task class to be executed (Step 1) 

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private String name;

    public Task(String s) {
        name = s;
    }

    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    @Override
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                if (i == 0) {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Initialization Time for" + " task name - " + name + " = " + ft.format(d));
                    // prints the initialization time for every task
                } else {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    System.out.println("Executing Time for task name - " + name + " = " + ft.format(d));
                    // prints the execution time for every task
                }
                Thread.sleep(1000);
            }
            System.out.println(name + " complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadPoolExample {
    // Maximum number of threads in thread pool
    static final int MAX_T = 2;

    public static void main(String[] args) {
        // creates five tasks
        Runnable r1 = new Task("Task - 1");
        Runnable r2 = new Task("Task - 2");
        Runnable r3 = new Task("Task - 3");
        Runnable r4 = new Task("Task - 4");
        Runnable r5 = new Task("Task - 5");
        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}
// One of the main advantages of using this approach is when you want to process
// 100 requests at a time, but do not want to create 100 Threads for the same,
// so as to reduce JVM overload. You can use this approach to create a
// ThreadPool of 10 Threads and you can submit 100 requests to this ThreadPool.
// ThreadPool will create maximum of 10 threads to process 10 requests at a
// time. After process completion of any single Thread,
// ThreadPool will internally allocate the 11th request to this Thread
// and will keep on doing the same to all the remaining requests.

// Executor Thread Pool Methods
// newFixedThreadPool(int) -> Creates a fixed size thread pool.
// newCachedThreadPool() -> Creates a thread pool that creates new
// threads as needed, but will reuse previously
// constructed threads when they are available
// newSingleThreadExecutor() -> Creates a single thread.

// In case of a fixed thread pool, if all threads are being currently run by the
// executor then the pending tasks are placed in a queue and are executed when a
// thread becomes idle.
