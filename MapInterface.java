import java.util.HashMap;
import java.util.Map;

public class MapInterface {
    public static void main(String[] args) {
        // Java program to demonstrate the
        // working of a HashMap
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "Geeks");
        hm.put(2, "For");
        hm.put(3, "Geeks");
        System.out.println("Value for 1 is : " + hm.get(1));
        // Travers through the hashmap
        for (Map.Entry<Integer, String> e : hm.entrySet()) {
            System.out.println(e.getKey() + " "
                    + e.getValue());
        }
    }
}
