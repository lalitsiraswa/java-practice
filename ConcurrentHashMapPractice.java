import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapPractice {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        System.out.println("Map Size : " + map.size());
        int valueA = map.get("A");
        System.out.println("Value of A : " + valueA);
        map.remove("B");
        System.out.println("Map Size : " + map.size());
        // Here we cant add 101 because "A" key
        // is already present in ConcurrentHashMap object
        map.putIfAbsent("A", 101);
        System.out.println(map);
        map.putIfAbsent("E", 102);
        System.out.println(map);
    }
}
