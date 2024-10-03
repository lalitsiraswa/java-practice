// Shallow Copy : In Shallow Copy, the pointer points to the same copy of the objects of class.
// Deep Copy : In Deep Copy, It creates copy of each object inside of the class.
// Shallow Copy reflects changes made to the new/copied object in the original object.
// Deep copy doesn’t reflect changes made to the new/copied object in the original object.

// -> Shallow Copy: Creates a new object but does not create copies of nested objects; instead, it copies references to the nested objects. Thus, changes to nested objects affect both the original and the copied objects.
// -> Deep Copy: Creates a new object and recursively copies all nested objects, so the original and copied objects are completely independent.

// Java program to illustrate the difference between shallow and deep copy

import java.util.ArrayList;

class Car {
    public String name;
    public ArrayList<String> colors;

    public Car(String name, ArrayList<String> colors) {
        this.name = name;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Car [name=" + name + ", colors=" + colors + "]";
    }

}

public class ShallowAndDeepCopy {
    public static void main(String[] args) {
        // Create a Honda car object
        ArrayList<String> hondaColors = new ArrayList<>();
        hondaColors.add("Red");
        hondaColors.add("Blue");
        Car honda = new Car("Honda", hondaColors);

        // Deep copy of Honda
        Car deepCopyHonda = new Car(honda.name, new ArrayList<>(honda.colors));
        System.out.println("Deep Copy :");
        System.out.println(deepCopyHonda);
        System.out.println("Original :");
        System.out.println(honda);
        System.out.println();

        // Shallow copy of honda
        Car copyHonda = honda;
        copyHonda.colors.add("Green");
        System.out.println("Shallow Copy :");
        System.out.println(copyHonda);
        System.out.println("Original :");
        System.out.println(honda);
    }
}
