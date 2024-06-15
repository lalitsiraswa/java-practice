class Test<T> {
    T obj;

    Test(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }
}

class Demo<T, U> {
    T obj1;
    U obj2;

    Demo(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void print() {
        System.out.println(obj1);
        System.out.println(obj2);
    }
}

public class GenericClassExample {
    public static void main(String[] args) {
        Test<Integer> iObj = new Test<Integer>(25);
        System.out.println(iObj.getObject());
        Test<String> sObj = new Test<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());

        // ------------
        Demo<String, Integer> demoObj = new Demo<String, Integer>("GFG", 25);
        demoObj.print();
    }
}
