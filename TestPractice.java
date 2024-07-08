import java.util.Arrays;

@FunctionalInterface
interface PrintInformation {
    abstract void printName();

    default void printAddress() {
        System.out.println("Rajasthan, India");
    }
}

// -----------------
class ShallowCopy {
    private int[] data;

    public ShallowCopy(int[] values) {
        data = values;
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}

// ---------------
class DeepCopy {

    private int[] data;

    public DeepCopy(int[] values) {
        data = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            data[i] = values[i];
        }
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}

// --------------
class Shape {
    int length;
    int width;
    int heigth;

    public Shape(Shape shape) {
        this.heigth = shape.heigth;
        this.width = shape.width;
        this.heigth = shape.heigth;
    }

    public Shape(int length, int width, int heigth) {
        this.length = length;
        this.width = width;
        this.heigth = heigth;
    }

    @Override
    public String toString() {
        return "Shape [length=" + length + ", width=" + width + ", heigth=" + heigth + "]";
    }
}

public class TestPractice {
    public static void main(String[] args) {
        // PrintInformation obj = () -> {
        // System.out.println("My Name Is Lalit Siraswa");
        // };
        // obj.printName();
        // obj.printAddress();

        // -----------------
        // new Thread(new Runnable() {
        // @Override
        // public void run() {
        // System.out.println("New thread created!");
        // }
        // }).run();
        // -------- Shallow Copy ----------
        int[] vals = { 3, 7, 9 };
        ShallowCopy shallowCopy = new ShallowCopy(vals);
        shallowCopy.showData();
        vals[0] = 13;
        shallowCopy.showData();
        // --------- Deep Copy ---------
        DeepCopy deepCopy = new DeepCopy(vals);
        deepCopy.showData();
        vals[0] = 3;
        deepCopy.showData();
        // -----------------
        Shape shape1 = new Shape(5, 2, 10);
        Shape shape2 = shape1; // Shellow Copy
        shape1.heigth = 20;
        System.out.println(shape2); 
        Shape shape3 = new Shape(shape1); // Deep Copy using Copy Constructor
        shape1.heigth = 10;
        System.out.println(shape3);
    }
}
