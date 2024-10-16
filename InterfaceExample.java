// Java program to demonstrate working of interface
// A simple interface
interface In1 {
    // public, static, final
    int a = 10;

    // public and abstract
    void display();
}

// Java program to demonstrate the real-world example of Interfaces
interface Vehicle {
    // all are the abstract methods.
    void changeGear(int a);

    void speedUp(int a);

    void applyBrakes(int a);
}

class Bicycle implements Vehicle {
    int speed;
    int gear;

    // to change gear
    @Override
    public void changeGear(int newGear) {
        gear = newGear;
    }

    // to increase speed
    @Override
    public void speedUp(int increment) {
        speed = speed + increment;
    }

    // to decrease speed
    @Override
    public void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    @Override
    public String toString() {
        return "speed: " + speed + " gear: " + gear;
    }
}

class Bike implements Vehicle {
    int speed;
    int gear;

    // to change gear
    @Override
    public void changeGear(int newGear) {
        gear = newGear;
    }

    // to increase speed
    @Override
    public void speedUp(int increment) {
        speed = speed + increment;
    }

    // to decrease speed
    @Override
    public void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    @Override
    public String toString() {
        return "speed: " + speed + " gear: " + gear;
    }
}

// New Features Added in Interfaces in JDK 8
// 1. Prior to JDK 8, the interface could not define the implementation. We can
// now add default implementation for interface methods. This default
// implementation has a special use and does not affect the intention behind
// interfaces.

interface DefaultMethod {
    int a = 10;

    default void printHelloWorld() {
        System.out.println("Hello World!");
    }
}

// 2. Another feature that was added in JDK 8 is that we can now define static
// methods in interfaces that can be called independently without an object.

interface StaticMethod {
    int a = 10;

    static void showHello() {
        System.out.println("Hello From Static Method!");
    }
}

// In general, the development process is step by step:
// Level 1 – interfaces: It contains the service details.
// Level 2 – abstract classes: It contains partial implementation.
// Level 3 – implementation classes: It contains all implementations.
// Level 4 – Final Code / Main Method: It have access of all interfaces data.

// Level-1
interface Bank {
    void deposit();

    void withdraw();

    void loan();

    void account();
}

// Level-2
abstract class Dev1 implements Bank {
    @Override
    public void deposit() {
        System.out.println("Your Deposit Amount : " + 100);
    }
}

abstract class Dev2 extends Dev1 {
    @Override
    public void withdraw() {
        System.out.println("Your Withdraw Amount : " + 50);
    }
}

// Level-3
class Dev3 extends Dev2 {

    @Override
    public void loan() {
        System.out.println("Your Loan Amount : " + 500);
    }

    @Override
    public void account() {
        System.out.println("Your Account Information");
    }
}

// Level-4
// A class that implements the interface.
public class InterfaceExample implements In1, DefaultMethod {
    // Implementing the capabilities of interface.
    @Override
    public void display() {
        System.out.println("Geeks For Geeks");
    }

    // Driver Code
    public static void main(String[] args) {
        InterfaceExample obj = new InterfaceExample();
        obj.display();
        System.out.println(In1.a);
        // -------------------------
        // creating an instance of Bicycle
        // doing some operations
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2);
        bicycle.speedUp(3);
        bicycle.applyBrakes(1);

        System.out.println("Bicycle present state :");
        System.out.println(bicycle);

        // creating instance of the bike.
        Bike bike = new Bike();
        bike.changeGear(1);
        bike.speedUp(4);
        bike.applyBrakes(3);

        System.out.println("Bike present state :");
        System.out.println(bike);
        // -------------------------------
        System.out.println("--------------- Default Method --------------");
        InterfaceExample defaultMethod = new InterfaceExample();
        defaultMethod.printHelloWorld();
        // -------------- Static Method In Interface -----------------
        StaticMethod.showHello();
        // -----------------------------------------------------------
        Dev3 d = new Dev3();
        d.account();
        d.loan();
        d.deposit();
        d.withdraw();
    }
}

// New Features Added in Interfaces in JDK 9
// From Java 9 onwards, interfaces can contain the following also:
// 1. Static methods
// 2. Private methods
// 3. Private Static methods