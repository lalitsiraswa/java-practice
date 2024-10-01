package ObjectOrientedProgrammingConcept;

// Java Program to demonstrate
// Java Encapsulation

// Person Class
class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class EncapsulationImplementation {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("John");
        person.setAge(30);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
