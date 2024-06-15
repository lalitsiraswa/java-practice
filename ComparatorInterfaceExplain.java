import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Compare method returns -1, 0, or 1 to say if it is less than, equal, or greater to the other.
class Student {
    int rollno;
    String name;
    String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + "]";
    }
}

class SortByRollNo implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.rollno - o2.rollno;
    }
}

class SortByName implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class ComparatorInterfaceExplain {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student(111, "Mayank", "london"));
        list.add(new Student(131, "Anshul", "nyc"));
        list.add(new Student(121, "Solanki", "jaipur"));
        list.add(new Student(101, "Aggarwal", "Hongkong"));
        // Display message on console for better readability
        System.out.println("Unsorted");

        // Iterating over entries to print them
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        // Sorting student entries by roll number
        Collections.sort(list, new SortByRollNo());

        // Display message on console for better readability
        System.out.println("\nSorted by rollno");

        // Again iterating over entries to print them
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        // Sorting student entries by name
        Collections.sort(list, new SortByName());

        // Display message on console for better readability
        System.out.println("\nSorted by name");

        // // Again iterating over entries to print them
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
