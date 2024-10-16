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
    }
}
