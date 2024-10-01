package ObjectOrientedProgrammingConcept;

// Java program to illustrate the
// concept of inheritance
// base class
class Bicycle {
    public int gear;
    public int speed;

    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBreak(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    @Override
    public String toString() {
        return ("No of gears are " + gear + "\n" + "speed of bicycle is " + speed);
    }
}

// derived class
class MountainBike extends Bicycle {
    public int seatHeight;

    public MountainBike(int gear, int speed, int seatHeight) {
        super(gear, speed);
        this.seatHeight = seatHeight;
    }

    public void setSeatHeight(int searHeight) {
        this.seatHeight = seatHeight;
    }

    // overriding toString() method of Bicycle to print more info
    @Override
    public String toString() {
        return (super.toString() + "\nseat height is " + seatHeight);
    }
}

// Java Program to illustrate Inheritance
class Employee {
    int salary = 60000;
}

class Engineer extends Employee {
    int benefits = 10000;
}

public class InheritanceImplementation {
    public static void main(String[] args) {
        MountainBike mb = new MountainBike(3, 100, 25);
        System.out.println(mb.toString());
        // ------------------------------
        Engineer E1 = new Engineer();
        System.out.println("Salary : " + E1.salary + "\nBenefits : " + E1.benefits);
    }
}
