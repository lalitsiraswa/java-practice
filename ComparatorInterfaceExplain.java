import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;

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
// By changing the return value inside the compare method, you can sort in any
// order that you wish to, for example: For descending order just change the
// positions of ‘a’ and ‘b’ in the above compare method.

// Sort collection by more than one field
class StudentCls {
    String name;
    int age;

    public StudentCls(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}

class CustomSortingComparator implements Comparator<StudentCls> {
    @Override
    public int compare(StudentCls o1, StudentCls o2) {
        int nameCompare = o1.getName().compareTo(o2.getName());
        int ageCompare = Integer.compare(o1.getAge(), o2.getAge());
        return (nameCompare == 0) ? ageCompare : nameCompare;
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

        // Sort collection by more than one field
        List<StudentCls> ls = new ArrayList<StudentCls>();
        ls.add(new StudentCls("Ajay", 27));
        ls.add(new StudentCls("Sneha", 23));
        ls.add(new StudentCls("Simran", 37));
        ls.add(new StudentCls("Ajay", 22));
        ls.add(new StudentCls("Ajay", 29));
        ls.add(new StudentCls("Sneha", 22));

        Iterator<StudentCls> stuIterator = ls.iterator();
        System.out.println("Before Sorting:\n");
        while (stuIterator.hasNext()) {
            System.out.println(stuIterator.next());
        }
        // Sorting using sort method of Collections class
        Collections.sort(ls, new CustomSortingComparator());

        // Display message only
        System.out.println("\n\nAfter Sorting:\n");

        // Iterating using enhanced for-loop
        // after Sorting ArrayList
        for (StudentCls student : ls) {
            System.out.println(student);
        }
    }
}
