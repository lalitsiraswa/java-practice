class GFG {
    static String Employee_name;
    static float Employee_salary;

    static void set(String name, float salary) {
        Employee_name = name;
        Employee_salary = salary;
    }

    static void get() {
        System.out.println("Employee name is : " + Employee_name);
        System.out.println("Employee CTC us : " + Employee_salary);
    }
}

// Class Declaration
class Dog {
    // Instance Variables
    String name;
    String breed;
    int age;
    String color;

    // Constructor Declaration of class
    public Dog(String name, String breed, int age, String color) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return ("Hi my name is " + this.getName()
                + ".\nMy breed,age and color are "
                + this.getBreed() + "," + this.getAge()
                + "," + this.getColor());
    }
}

public class ClassExample {
    public static void main(String[] args) {
        GFG.set("Rathore Avinash", 2000000);
        GFG.get();
        Dog tuffy = new Dog("Tuffy", "Paplillon", 5, "White");
        System.out.println(tuffy);
    }
}
