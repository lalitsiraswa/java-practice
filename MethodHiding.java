// If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass. This mechanism happens because the static method is resolved at the compile time. Static method bind during the compile time using the type of reference not a type of object.
// Java program to demonstrate
// Difference between method overriding and Method hiding
// Base Class
class Complex {
    public static void f1() {
        System.out.println("f1 method of the Complex class is executed.");
    }

    public void f2() {
        System.out.println("f2 method of the Complex class is executed.");
    }
}

// class child extend Complex class
class Sample extends Complex {
    public static void f1() {
        System.out.println("f1 of the Sample class is executed.");
    }

    @Override
    public void f2() {
        System.out.println("f2 method of the Sample class is executed.");
    }
}

public class MethodHiding {
    public static void main(String[] args) {
        Complex d1 = new Complex();
        // d2 is the reference variable of class Complex that
        // points to object of class Sample
        Complex d2 = new Sample();
        // But here method will be called using type of
        // reference
        d1.f1();
        d2.f1();
        // ***** Function overriding in java *****//
        // method refer to the object in the method
        // overriding.
        d1.f2();
        d2.f2();
    }
}
