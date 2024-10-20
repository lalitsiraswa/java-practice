// Method overloading may or may not require inheritance.
// Method overriding always needs inheritance.
// Private, final and static methods can be overloaded.
// Private, final and static methods can’t be overridden.

// Java Program to Implement Method Overloading
class MethodOverloadingEx {
    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }
}

// Java Program to Implement Method Overriding
class Animal {
    void eat() {
        System.out.println("eat() method of base class");
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("eat() method of derived class");
        System.out.println("Dog is eating.");
    }

    // Method to call the base class method
    void eatAsAnimal() {
        super.eat();
    }
}

// --------------------
class Parent {
    void sayHello() {
        System.out.println("Hello From Parent Class!");
    }

    void fun() {
        System.out.println("Fun() From Parent Class!");
    }
}

class Child extends Parent {
    @Override
    void sayHello() {
        System.out.println("Hello From Child Class!");
    }

    void printClassName() {
        System.out.println(this.getClass());
    }

    void fun(String str) {
        System.out.println("Fun() from Child Class!");
    }
}

public class MethodOverloadingAndMethodOverriding {
    public static void main(String[] args) {
        System.out.println("add() with 2 parameters");
        // Calling function with 2 parameters
        System.out.println(MethodOverloadingEx.add(4, 6));

        System.out.println("add() with 3 parameters");
        // Calling function with 3 Parameters
        System.out.println(MethodOverloadingEx.add(4, 6, 7));
        // -------------------------------
        Dog d1 = new Dog();
        Animal a1 = new Animal();
        d1.eat();
        a1.eat();
        Animal animal = new Dog();
        animal.eat();
        ((Dog) animal).eatAsAnimal();
        // --------------------------------
        Child child = new Child();
        child.sayHello();
        child.printClassName();
        // --------------------------------
        Parent parentChild = new Child();
        // ((Child) parentChild).fun("Lalit");
    }
}
