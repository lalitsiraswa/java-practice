// -------- Constructor Overloading ------------

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Hospital {
    int variable1, variable2;
    double variable3;

    public Hospital(int doctor, int nurses) {
        variable1 = doctor;
        variable2 = nurses;
    }

    public Hospital(int doctor) {
        variable1 = doctor;
    }

    public Hospital(double salaries) {
        variable3 = salaries;
    }
}

// ------ Copy Constructor -------
class InterviewBit {
    String department;
    String service;

    InterviewBit(InterviewBit iBit) {
        this.department = iBit.department;
        this.service = iBit.service;
    }
}

// ------ Method Overloading -------
class OverloadingHelp {
    public int findArea(int l, int b) {
        int var1;
        var1 = l * b;
        return var1;
    }

    public int findArea(int l, int b, int h) {
        int var2;
        var2 = l * b * h;
        return var2;
    }
}

// ------ Method Overriding --------
class HumanBeing {
    public int walk(int distance, int time) {
        int speed = distance / time;
        return speed;
    }
}

class Athlete extends HumanBeing {
    public int walk(int distance, int time) {
        int speed = distance / time;
        speed = speed * 2;
        return speed;
    }
}

// ----- Singel try with multiple catch blocks ------
class MultipleCatch {
    public static void multiCatch() {
        try {
            int x = 10 / 0;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("ArrayIndexOutOfBoundsException " + exception.getMessage());
        } catch (ArithmeticException exception) {
            System.out.println("ArithmeticException " + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("Exception " + exception.getMessage());
        } finally {
            System.out.println("It get executed irrespective of handling of exceptions.");
        }
    }
}

// --------- Finalize ----------
class FinalizeExample {
    public static void finalizeCall() {
        String str = new String("Example String");
        str = null;
        System.gc(); // Garbage collector called
    }

    // public void finalize() {
    // System.out.println(
    // "Finalize: Prior to the garbage collection of an object, the finalize method
    // is called so that the clean-up activity is implemented.");
    // }
}

// ------- super keyword ---------
class Parent {
    protected int num = 1;

    public Parent() {
        System.out.println("Parent class default constructor.");
    }

    public Parent(String s) {
        System.out.println("Parent class parameterised constructor.");
    }

    public void foo() {
        System.out.println("Parent class foo!");
    }
}

class Child extends Parent {
    private int num = 2;

    public Child() {
        // super(); // default constructor
        super("Call Parent");
        System.out.println("Child class default Constructor");
    }

    void printNum() {
        System.out.println(num);
        System.out.println(super.num);
    }

    @Override
    public void foo() {
        System.out.println("Child class foo!");
        super.foo();
    }
}

// ------ shallow copy and deep copy ---------
class Rectangle {
    int length = 5;
    int breadth = 3;
}

// ------ Singleton Class -------
class WaterJug {
    private int waterQuantity = 500;

    private WaterJug() {
    }

    private static WaterJug object = null;

    // Method to provide the service of Giving Water.
    public int getWater(int quantity) {
        waterQuantity -= quantity;
        return quantity;
    }

    // Method to return the object to the user.
    public static WaterJug getInstance() {
        // Will Create a new object if the object is not already created and return the
        // object.
        if (object == null) {
            object = new WaterJug();
        }
        return object;
    }
}

// ----- Single Responsibility Principle (SRP) -------
// Reference link :
// https://www.freecodecamp.org/news/solid-principles-explained-in-plain-english/
class Book {
    String name;
    String authorName;
    int year;
    int price;
    String isbn;

    public Book(String name, String authorName, int year, int price, String isbn) {
        this.name = name;
        this.authorName = authorName;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
    }
}

class Invoice {
    Book book;
    int quantity;
    double discountRate;
    double taxRate;
    double total;

    public Invoice(Book book, int quantity, double discountRate, double taxRate, double total) {
        this.book = book;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.taxRate = taxRate;
        this.total = total;
    }

    public double calculateTotal() {
        double price = ((book.price - (book.price * discountRate)) * this.quantity);
        double priceWithTaxes = price * (1 + taxRate);
        return priceWithTaxes;
    }

    // public void printInvoice() {
    // System.out.println(quantity + "x " + book.name + " " + book.price + "$");
    // System.out.println("Discount Rate: " + discountRate);
    // System.out.println("Tax Rate: " + taxRate);
    // System.out.println("Total: " + total);
    // }

    // public void saveToFile(String filename) {
    // // Creates a file with given name and writes the invoice
    // }
}

class InvoicePrinter {
    private Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        System.out.println(invoice.quantity + "x " + invoice.book.name + " " + invoice.book.price + "$");
        System.out.println("Discount Rate: " + invoice.discountRate);
        System.out.println("Tax Rate: " + invoice.taxRate);
        System.out.println("Total: " + invoice.total);
    }
}

class InvoicePersistance {
    private Invoice invoice;

    public InvoicePersistance(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToFile(String filename) {
        // Creates a file with given name and writes the invoice
    }
}

// --------- Open-Closed Principle (OCP) -----------
interface InvoicePersistanceInterface {
    public void save(Invoice invoice);
}

class DatabasePersistence implements InvoicePersistanceInterface {

    @Override
    public void save(Invoice invoice) {
        // Save to DB
    }
}

class FilePersistance implements InvoicePersistanceInterface {

    @Override
    public void save(Invoice invoice) {
        // Save to file
    }
}

// ----- Liskov Substitution Principle --------
class RectangleBox {
    protected int width, height;

    public RectangleBox() {
    }

    public RectangleBox(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class SquareBox extends RectangleBox {
    public SquareBox() {
    }

    public SquareBox(int size) {
        width = height = size;
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

// -------- Interface Segregation Principle ---------
class Car {
}

interface ParkingLot {
    void parkCar();// Decrease empty spot count by 1

    void unparkCar();// Increase empty spots by 1

    void getCapacity();// Returns car capacity
}

interface FreeParkingLot extends ParkingLot {

}

interface PaidParkingLot extends ParkingLot {
    double calculateFee(Car car); // Returns the price based on number of hours

    void doPaymant(Car car);
}

class FreeParking implements FreeParkingLot {

    @Override
    public void parkCar() {
    }

    @Override
    public void unparkCar() {
    }

    @Override
    public void getCapacity() {
    }

    // @Override
    // public double calculateFee(Car car) {
    // return 0;
    // }

    // @Override
    // public void doPaymant(Car car) {
    // try {
    // throw new Exception("Parking lot is free");
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
}

// --------------------------
class Oerloading {
    double method(int x, double y) {
        return x * y;
    }

    double method(String x, String y) {
        return 2.4;
    }
}

// --------------------------
class Animal {
    protected String type;

    protected void displayType() {
        System.out.println("Type: " + type);
    }
}

// public class Practice {
// // ----- Liskov Substitution Principle --------
// static void getAreaTest(RectangleBox r) {
// int width = r.getWidth();
// r.setHeight(10);
// System.out.println("Expected area of " + (width * 10) + ", got " +
// r.getArea());
// }

// public static void main(String[] args) {
// Animal obj = new Animal();
// obj.displayType();
// // ------------------
// // MultipleCatch.multiCatch();
// // FinalizeExample.finalizeCall();
// // -------------
// // Child childObj = new Child();
// // childObj.foo();
// // childObj.printNum();
// // --------------
// // Rectangle obj1 = new Rectangle();
// // Rectangle obj2 = obj1; // shallow copy
// // Rectangle obj3 = new Rectangle();
// // deep copy
// // obj3.length = obj1.length;
// // obj3.breadth = obj1.breadth;
// // ------- Singleton Class -------
// // WaterJug waterJug = WaterJug.getInstance();
// // waterJug.getWater(1);
// // ----- Liskov Substitution Principle --------
// // RectangleBox rc = new RectangleBox(2, 3);
// // getAreaTest(rc);
// // RectangleBox sq = new SquareBox();
// // sq.setWidth(5);
// // getAreaTest(sq);
// // ---------------
// // Oerloading obj = new Oerloading();
// // System.out.println(obj.method("l", "s"));
// }
// }
// ---------------------------

public class Practice {
    public static void main(String[] args) {
        // List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // list = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        // list.forEach(System.out::println);
        try {

        } finally {

        }
    }
}