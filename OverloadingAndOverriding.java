// Method Overloading in Java
// In Java, Method Overloading allows different methods to have the same name, but different signatures where the signature can differ by the number of input parameters or type of input parameters, or a mixture of both.
// In Method overloading compared to the parent argument, the child argument will get the highest priority.
// Java program to demonstrate working of method overloading in Java 

class Sum {
    public int sum(int x, int y) {
        return x + y;
    }

    public int sum(int x, int y, int z) {
        return x + y + z;
    }

    // Overloaded sum(). This sum takes two double
    // parameters
    public double sum(double x, double y) {

        return x + y;
    }
}

// Different Ways of Method Overloading in Java
// 1. Changing the Number of Parameters.
// 2. Changing Data Types of the Arguments.
// 3. Changing the Order of the Parameters of Methods

// Method overriding is one of the ways by which Java achieves Run Time
// Polymorphism. The version of a method that is executed will be determined by
// the object that is used to invoke it. If an object of a parent class is used
// to invoke the method, then the version in the parent class will be executed,
// but if an object of the subclass is used to invoke the method, then the
// version in the child class will be executed. In other words, it is the type
// of the object being referred to (not the type of the reference variable) that
// determines which version of an overridden method will be executed.

// Java program to demonstrate
// method overriding in java
class Parent {
    void show() {
        System.out.println("Parent's show()");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child's show()");
    }
}

// 1. Overriding and Access Modifiers
// The access modifier for an overriding method can allow more, but not less,
// access than the overridden method.
class ParentClass {
    private void m1() {
        System.out.println("From parent m1()");
    }

    protected void m2() {
        System.out.println("From parent m2()");
    }
}

class ChildClass extends ParentClass {
    private void m1() {
        System.out.println("From child m1()");
    }

    @Override
    public void m2() {
        System.out.println("From child m2()");
    }
}

public class OverloadingAndOverriding {
    public static void main(String[] args) {
        Sum s = new Sum();
        System.out.println(s.sum(10, 20));
        System.out.println(s.sum(10, 20, 30));
        System.out.println(s.sum(10.5, 20.5));
        // ---------------------------------------
        Parent parent = new Parent();
        parent.show();
        Parent parent2 = new Child();
        parent2.show();
    }
}
