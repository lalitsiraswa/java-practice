import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

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
        System.out.println();
        // Java program to demonstrate the
        // working of LinkedList
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++)
            ll.add(i);
        System.out.println(ll);
        Iterator<Integer> iterator = ll.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.print(num + " ");
        }
        ll.remove(3);
        System.out.println("\n" + ll);

        // Java program to demonstrate the
        // working of Vector
        System.out.println("------------- Vector -----------------");
        Vector<Integer> v = new Vector<Integer>();
        for (int i = 1; i <= 5; i++)
            v.add(i);
        System.out.println(v);
        v.remove(3);
        System.out.println(v);
        System.out.println();
        Iterator<Integer> iterator2 = v.iterator();
        while (iterator2.hasNext()) {
            int num = iterator2.next();
            System.out.print(num + " ");
        }
    }
}
