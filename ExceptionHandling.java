// What are Java Exceptions?
// In Java, Exception is an unwanted or unexpected event, which occurs during the execution of a program, i.e. at run time, that disrupts the normal flow of the program’s instructions. Exceptions can be caught and handled by the program. When an exception occurs within a method, it creates an object. This object is called the exception object. It contains information about the exception, such as the name and description of the exception and the state of the program when the exception occurred.

// Errors represent irrecoverable conditions such as Java virtual machine (JVM) running out of memory, memory leaks, stack overflow errors, library incompatibility, infinite recursion, etc. Errors are usually beyond the control of the programmer, and we should not try to handle errors.
public class ExceptionHandling {
    public static void main(String[] args) {
        // program to print the exception information using printStackTrace() method
        int a = 5;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            // print the exception information using toString() method
            System.out.println(e.toString());
            // print the exception information using getMessage() method
            System.out.println(e.getMessage());
        }
        // --------------------------------------------------
        
    }
}
