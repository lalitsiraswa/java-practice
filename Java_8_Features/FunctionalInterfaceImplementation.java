// Some Built-in Java Functional Interfaces
// Runnable –> This interface only contains the run() method.
// Comparable –> This interface only contains the compareTo() method.
// ActionListener –> This interface only contains the actionPerformed() method.
// Callable –> This interface only contains the call() method.
@FunctionalInterface
interface Square {
    int calculate(int x);
}

public class FunctionalInterfaceImplementation {
    public static void main(String[] args) {
        // Before Java 8, we had to create anonymous inner class objects or
        // implement
        // these interfaces.
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New thread created");
            }
        }).start();
        // Java 8 onwards, we can assign lambda expression to its functional interface
        // object like this:
        new Thread(() -> {
            System.out.println("New thread created!");
        }).start();
        // Functional Interface
        Square s = (int x) -> x * x;
        System.out.println(s.calculate(4));
    }
}
