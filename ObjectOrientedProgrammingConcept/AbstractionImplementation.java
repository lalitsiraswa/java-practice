package ObjectOrientedProgrammingConcept;

import org.w3c.dom.css.Rect;

// Java program to illustrate the
// concept of Abstraction
abstract class Shape {
    String color;

    // these are abstract methods
    abstract double area();

    public abstract String toString();

    // abstract class can have the constructor
    protected Shape(String color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }

    // this is a concrete method
    public String getColor() {
        return color;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        // calling Shape constructor
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle color is : " + super.getColor() + " and area is : " + area();
    }
}

class Rectangle extends Shape {

    double length;
    double width;

    public Rectangle(String color, double length, double width) {
        // calling Shape constructor
        super(color);
        System.out.println("Rectangle constructor called");
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle color is " + super.getColor()
                + "and area is : " + area();
    }
}

// Java Program to implement
// Java Abstraction

// Abstract Class declared
abstract class Animal {
    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }
}

// Abstracted class
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(getName() + " barks");
    }
}

// Abstracted class
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public void makeSound() {
        System.out.println(getName() + " meows");
    }
}

// --------------------- Interface ----------------------
// Define an interface named Shape
interface ShapeInterface {
    // Abstract method for calculating the area
    double calculateArea();
}

// Implement the interface in a class named Circle
class CircleClass implements ShapeInterface {
    private double radius;

    // Constructor for circle
    public CircleClass(double radius) {
        this.radius = radius;
    }

    // Implementing the abstract method from the Shape
    // interface
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

// Implement the interface in a class named Rectangle
class RectangleClass implements ShapeInterface {
    private double length;
    private double width;

    // Constructor for Rectangle
    public RectangleClass(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementing the abstract method from the Shape
    // interface
    public double calculateArea() {
        return length * width;
    }
}

public class AbstractionImplementation {
    public static void main(String[] args) {
        Shape s1 = new Circle("Red", 2.2);
        System.out.println(s1);
        Shape s2 = new Rectangle("Yellow", 2, 4);
        System.out.println(s2);
        // ------------------------
        Animal myDog = new Dog("Buddy");
        myDog.makeSound();
        Animal myCat = new Cat("Fluffy");
        myCat.makeSound();
        // -------------------------
        CircleClass circleClass = new CircleClass(5.0);
        System.out.println("Area of Circle: " + circleClass.calculateArea());
        RectangleClass rectangleClass = new RectangleClass(4.0, 6.0);
        System.out.println("Area of Rectangle: " + rectangleClass.calculateArea());
    }
}
