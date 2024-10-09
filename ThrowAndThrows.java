// Java throws
// throws is a keyword in Java that is used in the signature of a method to indicate that this method might throw one of the listed type exceptions. The caller to these methods has to handle the exception using a try-catch block. 
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

    // Java program to demonstrate working of throws
    static void funThrows() throws IllegalAccessException {
        System.out.println("Inside funThrows()");
        throw new IllegalAccessException("Throws Demo");
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            fun();
        } catch (NullPointerException ex) {
            System.out.println("Caught in main()");
        } finally {
            System.out.println("finally from main()");
        }
        // --------------------------------------------
        Thread.sleep(5000);
        System.out.println("End of the program");
        // ---------------
        try {
            funThrows();
        } catch (IllegalAccessException ex) {
            System.out.println("Caught in main() - Throws");
        }
    }
}
