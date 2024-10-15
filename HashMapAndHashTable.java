import java.util.Hashtable;
import java.util.Map;

public class HashMapAndHashTable {
    public static void main(String[] args) {
        // ------------- Hash Table --------------
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
        ht.put(101, "Ajay");
        ht.put(101, "Vijay");
        ht.put(102, "Ravi");
        ht.put(103, "Rahul");
        System.out.println("------------- Hash Table --------------");
        for (Map.Entry m : ht.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
