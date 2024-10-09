public class ThrowAndThrows {
    // Java program that demonstrates the use of throw
    static void fun() {
        try {
            throw new NullPointerException("Demo");
            // Unreachable code
            // System.out.println("Statement after exception throw");
        } catch (NullPointerException ex) {
            System.out.println("Caught inside fun().");
            throw ex;
        } finally {
            System.out.println("finally from fun()");
        }
    }

    public static void main(String[] args) {
        try {
            fun();
        } catch (NullPointerException ex) {
            System.out.println("Caught in main()");
        } finally {
            System.out.println("finally from main()");
        }
        System.out.println("End of the program");
    }
}
