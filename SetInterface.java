import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetInterface {
    public static void main(String[] args) {
        System.out.println("------ HashSet -------");
        // Java program to demonstrate the
        // working of a HashSet
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Geeks");
        hashSet.add("For");
        hashSet.add("Geeks");
        hashSet.add("Is");
        hashSet.add("Very helpful");
        hashSet.add(null);
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }

        System.out.println("------- LinkedHashSet --------");
        // Java program to demonstrate the
        // working of a LinkedHashSet
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        lhs.add("Geeks");
        lhs.add("For");
        lhs.add("Geeks");
        lhs.add("Is");
        lhs.add("Very helpful");
        iterator = lhs.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }

        System.out.println("------ Sorted Set Interface -------");
        // Java program to demonstrate the
        // working of a TreeSet
        TreeSet<String> ts = new TreeSet<String>();
        ts.add("Geeks");
        ts.add("For");
        ts.add("Geeks");
        ts.add("Is");
        ts.add("Very helpful");
        iterator = ts.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "  ");
        }
    }
}
