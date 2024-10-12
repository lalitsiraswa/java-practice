import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TVSet {
    private static volatile TVSet tvSetInstance = null;

    private TVSet() {
        System.out.println("TV Set Instantiated!");
    }

    public static TVSet getTVSetInstance() {
        if (tvSetInstance == null) { // Optimisation
            synchronized (TVSet.class) {
                if (tvSetInstance == null) { // Double Checking
                    tvSetInstance = new TVSet();
                }
            }
        }
        return tvSetInstance;
    }
}

public class SingletonDesignPatternByRiddhiDutta {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Started");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> TVSet.getTVSetInstance());
        executorService.execute(() -> TVSet.getTVSetInstance());
        executorService.execute(() -> TVSet.getTVSetInstance());
        executorService.execute(() -> TVSet.getTVSetInstance());
        executorService.execute(() -> TVSet.getTVSetInstance());
        executorService.execute(() -> TVSet.getTVSetInstance());
        System.out.println(Thread.currentThread().getName() + " Exiting");
    }
}
