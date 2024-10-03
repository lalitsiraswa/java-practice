// Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. 
// This mechanism is used to persist the object.
// A Serializable class can declare its own UID explicitly by declaring a field name. It must be static, final and of type long. i.e- ANY-ACCESS-MODIFIER static final long serialVersionUID=42L;
// Only non-static data members are saved via Serialization process. 
// Static data members and transient data members are not saved via Serialization process. So, if you don’t want to save value of a non-static data member then make it transient. 

// Java code for serialization and deserialization of a Java object

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Demo implements Serializable {
    public int a;
    public String b;

    public Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

// Java code for serialization and deserialization of a Java object
// Only non-static data members are saved via Serialization process.
// Static data members and transient data members are not saved via
// Serialization process. So, if you don’t want to save value of a non-static
// data member then make it transient.
class Employee implements Serializable {
    private static final long serialversionUID = 129348938L;
    transient int a;
    static int b;
    String name;
    int age;

    public Employee(String name, int age, int a, int b) {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
    }
}

// In case of transient variables:- A variable defined with transient keyword is
// not serialized during serialization process.This variable will be initialized
// with default value during deserialization. (e.g: for objects it is null, for
// int it is 0).

// In case of static Variables:- A variable defined with static keyword is not
// serialized during serialization process.This variable will be loaded with
// current value defined in the class during deserialization.
public class SerializationAndDeserialization {
    public static void printData(Employee employee) {
        System.out.println("Name : " + employee.name);
        System.out.println("Age : " + employee.age);
        System.out.println("a : " + employee.a);
        System.out.println("b : " + employee.b);
    }

    public static void main(String[] args) {
        // ---------------------------------------------
        Demo object = new Demo(1, "Geeks For Geeks");
        String filename = "serialized_file.ser";
        // Serialization
        try {
            // Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(object);
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
        Demo objecDemo = null;
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            // Method for deserialization of object
            objecDemo = (Demo) in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized");
            System.out.println("a = " + objecDemo.a);
            System.out.println("b = " + objecDemo.b);
        } catch (IOException ex) {
            System.out.println("IOException is caught!");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught!");
        }
        // -----------------------------------------------------------
        Employee shubham = new Employee("Shubham", 20, 2, 1000);
        String filename2 = "shubham.txt";
        // Serialization
        try {
            // Saving of object in file
            FileOutputStream file = new FileOutputStream(filename2);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(shubham);
            out.close();
            file.close();
            System.out.println("Object has been serialized\n"
                    + "Data before Deserialization.");
            printData(shubham);
            // value of static variable changes
            shubham.b = 2000;
        } catch (IOException ex) {
            System.out.println("IOException is caught!");
        }
        shubham = null;
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename2);
            ObjectInputStream in = new ObjectInputStream(file);
            // Method for deserialization of object
            shubham = (Employee) in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized\n"
                    + "Data after Deserialization.");
            printData(shubham);
            // System.out.println("z = " + object1.z);
        } catch (IOException ex) {
            System.out.println("IOException is caught!");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught!");
        }
    }
}
