// Advantages of Generics
// 1. Code Reuse
// 2. Type Safety
// 3. Individual Type Casting is not needed
// 4. Generics Promotes Code Reusability
class Test {
    static <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);
    }
}

class Demo<T> {
    T obj;

    Demo(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }
}

public class GenericFunctionsExample {
    public static void main(String[] args) {
        Test.genericDisplay(11);
        Test.genericDisplay("GeeksForGeeks");
        Test.genericDisplay(1.0);
        Test tObj = new Test();
        tObj.genericDisplay("Testing");

        // Generics add type safety through this and prevent errors.
        Demo<Integer> iObj = new Demo<Integer>(25);
        System.out.println(iObj.getObject());
        Demo<String> sObj = new Demo<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());
        // iObj = sObj; // This results an error (Type-Safty)

        // Generics Promotes Code Reusability
    }
}
