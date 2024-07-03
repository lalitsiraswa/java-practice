import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapHashTable {
    public static void main(String[] args) {
        // ----------hashtable -------------------------
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
        ht.put(101, "Ajay");
        ht.put(101, "Vijay");
        ht.put(102, "Ravi");
        ht.put(103, "Rahul");
        System.out.println("-----Hash table----");
        for (Map.Entry<Integer, String> entry : ht.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());

        // ----------------hashmap--------------------------------
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(100, "Amit");
        hm.put(104, "Amit");
        hm.put(101, "Vijay");
        hm.put(102, "Rahul");
        System.out.println("-----------Hash map-----------");
        for (Map.Entry<Integer, String> entry : hm.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}
