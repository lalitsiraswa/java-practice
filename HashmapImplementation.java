import java.util.ArrayList;
import java.util.List;

// k -> Key
// V -> Value
class OurMap<K, V> {
    private List<MapNode<K, V>> bucket;
    private int capacity; // length of the bucket
    private int size; // number of elements in the map;
    private final int INITIAL_CAPACITY = 5; // initial length of the bucket array

    public OurMap() {
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key) {
        // Get the memory address of the object
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int bucketindex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketindex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        MapNode<K, V> newEntry = new MapNode<K, V>(key, value);
        head = bucket.get(bucketindex);
        newEntry.next = head;
        bucket.set(bucketindex, newEntry);

        // n : number of entries in the whole bucket i.e size in this case
        // b : bucket size i.e capacity in this case
        // (n/b) is called load factor and it should be always less than 0.75.
        double loadFactor = (1.0 * size) / capacity;
        System.out.println("Inserting Key : " + key);
        System.out.println("Load Factor : " + loadFactor);
        if (loadFactor > 0.75) {
            rehash();
        }
    }

    private void rehash() {
        System.out.println("Reshashing Buckets");
        List<MapNode<K, V>> temp = bucket;
        bucket = new ArrayList<>();
        capacity *= 2;
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
        size = 0;
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        MapNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null)
                    bucket.set(bucketIndex, head.next);
                else
                    prev.next = head.next;
                head.next = null;
                size--;
                break;
            }
            prev = head;
            head = head.next;
        }
    }

    private class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

public class HashmapImplementation {
    public static void main(String[] args) {
        OurMap<Integer, String> nameToLen = new OurMap<Integer, String>();
        nameToLen.put(1, "a");
        nameToLen.put(5, "lalit");
        nameToLen.put(7, "siraswa");
        nameToLen.put(5, "absxd");
        nameToLen.put(5, "lucky");
        nameToLen.put(3, "abc");
        System.out.println(nameToLen.get(5));
        System.out.println(nameToLen.get(1));
        System.out.println(nameToLen.get(3));
        System.out.println(nameToLen.get(7));
        System.out.println(nameToLen.get(4));
    }
}
