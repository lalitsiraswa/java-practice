import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.List;

class HashMapImpl<K, V> {
    private List<MapNode<K, V>> bucket;
    private int capacity; // length of the bucket
    private int size; // number of elements in the map
    private final int INITIAL_CAPACITY = 5; // initial length of the bucket array

    public HashMapImpl() {
        bucket = new ArrayList<MapNode<K, V>>();
        capacity = INITIAL_CAPACITY;
        // Below one is important step
        // if we are not adding element into the list, the list size will be zero(0)
        // only, that/s why we need to add null.
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key) {
        // Object class has this 'hashCode()' function, the hashCode() basically return
        // the memory address of the Object
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        MapNode<K, V> newEntry = new MapNode<K, V>(key, value);
        head = bucket.get(bucketIndex);
        newEntry.next = head;
        bucket.set(bucketIndex, newEntry);

        // (n/b) load factor -> n : number of entries in the hashmap
        // b : number of buckets
        double loadFactor = (1.0 * size) / capacity;

        System.out.println("inserting key : " + key);
        System.out.println("load factor : " + loadFactor);
        if (loadFactor > 0.7) {
            rehash();
        }
    }

    private void rehash() {
        System.out.println("Rehashing buckets");
        List<MapNode<K, V>> temp = bucket;
        bucket = new ArrayList<MapNode<K, V>>();
        capacity *= 2;
        for (int i = 0; i < capacity; i++)
            bucket.add(null);
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
        MapNode<K, V> previousNode = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (previousNode == null)
                    bucket.set(bucketIndex, head.next);
                else
                    previousNode.next = head.next;
                head.next = null;
                size--;
                break;
            }
            previousNode = head;
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
            next = null;
        }
    }
}

public class HashMapImplementation {
    public static void main(String[] args) {
        HashMapImpl<Integer, String> hashMap = new HashMapImpl<Integer, String>();
        hashMap.put(1, "Lalit");
        hashMap.put(6, "Krishna");
        hashMap.put(5, "Jyoti");
        hashMap.put(3, "Manisha");
        hashMap.put(5, "Manju Devi");

        System.out.println(hashMap.get(5));
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(6));
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(7));
    }
}
