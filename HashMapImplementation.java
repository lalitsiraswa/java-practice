import java.util.ArrayList;
import java.util.List;

class HashMapImpl<K, V> {
    private List<MapNode<K, V>> bucket;
    private int capacity; // length of the bucket
    private int size; // number of elements in the map
    private final int INITIAL_CAPACITY = 5; // initial length of the bucket array

    public HashMapImpl() {
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        // Below one is important step
        // if we are not adding element into the list, the list size will be zero(0)
        // only, that/s why we need to add null.
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key) {
        // Object class has this 'hashCode()' function,  
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        return null;
    }

    public void remove(K key) {

    }

    public void put(K key, V value) {

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

public class HashMapImplementation {
    public static void main(String[] args) {

    }
}
