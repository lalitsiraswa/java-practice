// Abstract class may have both abstract and non-abstract methods(methods with bodies).

// Default methods are allowed only in interfaces.

// By default, all members (methods and variables) of an abstract class in Java have package-private access. This means they are accessible within the same package but not from outside the package.
// However, you can explicitly specify the access modifiers for the members of an abstract class:
// 1. public: Accessible from anywhere.
// 2. protected: Accessible within the same package and by subclasses.
// 3. private: Accessible only within the class itself.
// 4. default (package-private): Accessible within the same package.

// 1. Example of Abstract Class that has Abstract method
// Abstract class
abstract class Sunstar {
    abstract void printInfo();
}

// Abstraction performed using extends
class Employee extends Sunstar {
    @Override
    void printInfo() {
        String name = "Avinash";
        int age = 21;
        float salary = 222.2F;
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Salary : " + salary);
    }
}

// 2. Abstract Class having constructor, data member, and methods
abstract class Subject {
    Subject() {
        System.out.println("Learning Subject");
    }

    abstract void syllabus();

    void Learn() {
        System.out.println("preparing Right Now!");
    }
}

class IT extends Subject {
    void syllabus() {
        System.out.println("C, JAVA, C++");
    }
}

// Like C++, an abstract class can contain constructors in Java. And a
// constructor of an abstract class is called when an instance of an inherited
// class is created.
abstract class Base {
    Base() {
        System.out.println("Base Constructor Called!");
    }

    abstract void fun();
}

class Derieved extends Base {
    Derieved() {
        // super();
        System.out.println("Derieved Constructor Called!");
    }

    void fun() {
        System.out.println("Derieved fun() called");
    }
}

// Similar to the interface we can define static methods in an abstract class
// that can be called independently without an object.
abstract class Helper {
    static void demofun() {
        System.out.println("Geeks For Geeks");
    }
}

// We can use the abstract keyword for declaring top-level classes (Outer class)
// as well as inner classes as abstract
abstract class B {
    abstract class C {
        abstract void myAbstractMethod();
    }
}

class D extends B {
    class E extends C {
        @Override
        void myAbstractMethod() {
            System.out.println("Insde abstract method implementation");
        }
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Sunstar s = new Employee();
        s.printInfo();
        // --------------------------------
        Subject x = new IT();
        x.syllabus();
        x.Learn();
        // --------------------------------
        Derieved d = new Derieved();
        d.fun();
        // --------------------------------
        Helper.demofun();
        // --------------------------------
        D outer = new D();
        D.E inner = outer.new E();
        inner.myAbstractMethod();
    }
}
