import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        // 1. Using entrySet() to Access Both Keys and Values:
        System.out.println("1. Using entrySet() to Access Both Keys and Values:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
        // 2. Using keySet() to Loop Through Keys:
        System.out.println("2. Using keySet() to Loop Through Keys:");
        for (String key : map.keySet()) {
            System.out.println("Key : " + key);
        }
        // 3. Using values() to Loop Through Values:
        System.out.println("3. Using values() to Loop Through Values:");
        for (Integer val : map.values()) {
            System.out.println("Value : " + val);
        }
        // 4. Using forEach() (Java 8 and Above):
        System.out.println("4. Using forEach() (Java 8 and Above):");
        map.forEach((key, value) -> {
            System.out.println("Key : " + key + ", Value : " + value);
        });
        // Using an Iterator (For Advanced Scenarios):
        System.out.println("Using an Iterator (For Advanced Scenarios):");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        // ----------------------
        List<Integer> integers = new ArrayList<>(List.of(2, 4, 6, 8, 10));
        Iterator<Integer> intIterator = integers.iterator();
        while (intIterator.hasNext()) {
            System.out.println(intIterator.next());
        }
    }
}
