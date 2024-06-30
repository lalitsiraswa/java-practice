import java.util.ArrayList;

public class ListInterface {
    public static void main(String[] args) {
        // ArrayList can not be used for primitive types, like int, char, etc. We will
        // need a wrapper class for such cases.

        // Java program to demonstrate the
        // working of ArrayList
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++)
            al.add(i);
        System.out.println(al);
        for (Integer item : al)
            System.out.print(item + " ");
        al.remove(3);
        System.out.println("\n" + al);
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
    }
}
