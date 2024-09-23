public class FunctionalInterfaceImplementation {
    public static void main(String[] args) {
        // Before Java 8, we had to create anonymous inner class objects or implement
        // these interfaces.
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("New thread created");
            }
        }).start();
    }
}
