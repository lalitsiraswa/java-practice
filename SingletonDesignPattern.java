package design_pattern;

// Java program implementing Singleton class
// with using  getInstance() method
class Singleton {
    // Static variable reference of single_instance
    // of type Singleton
    private static Singleton single_instance = null;
    // Declaring a variable of type String
    public String s;

    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private Singleton() {
        s = "Hello I am a string part of Singleton class";
    }

    // Static method
    // Static method to create instance of Singleton class
    public static synchronized Singleton getInstance() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        // Instantiating Singleton class with variable x
        Singleton x = Singleton.getInstance();
        // Instantiating Singleton class with variable y
        Singleton y = Singleton.getInstance();
        // Instantiating Singleton class with variable z
        Singleton z = Singleton.getInstance();
        // Printing the hash code for above variable as
        // declared
        System.out.println("Hashcode of x is "
                + x.hashCode());
        System.out.println("Hashcode of y is "
                + y.hashCode());
        System.out.println("Hashcode of z is "
                + z.hashCode());
        // Condition check
        if (x == y && y == z) {
            // Print statement
            System.out.println(
                    "Three objects point to the same memory location on the heap i.e, to the same object");
        } else {
            // Print statement
            System.out.println(
                    "Three objects DO NOT point to the same memory location on the heap");
        }

        // Now changing variable of instance x
        // via toUpperCase() method
        x.s = (x.s).toUpperCase();
        // Print and display commands
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
        System.out.println("\n");
        // Now again changing variable of instance z
        z.s = (z.s).toLowerCase();
        System.out.println("String from x is " + x.s);
        System.out.println("String from y is " + y.s);
        System.out.println("String from z is " + z.s);
    }
}
