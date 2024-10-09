// A Class that represents use-defined exception
class MyException extends Exception {
    public MyException(String s) {
        // Call constructor of parent Exception
        super(s);
    }
}

// The constructor of the Exception class can also be called without a parameter
// and the call to super is not mandatory.
class MyException2 extends Exception {

}

public class CustomException {
    public static void main(String[] args) {
        try {
            // Throw an object of user defined exception
            throw new MyException("Geeks For Geeks");
        } catch (MyException ex) {
            System.out.println("Custom Exception Caught");
            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }
        // ---------------------
        try {
            throw new MyException2();
        } catch (MyException2 ex) {
            System.out.println("MyException2 Caught");
            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }
    }
}
