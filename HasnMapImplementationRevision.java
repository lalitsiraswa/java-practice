import java.util.ArrayList;
import java.util.List;

class HashMapImplRevise<K, V> {
    private List<HashMapNode<K, V>> bucket;
    private int capacity; // length of the bucket
    private int size; // number of elements in the map
    private final int INITIAL_CAPACITY = 5; // initial length of the bucket array

    public HashMapImplRevise() {
        bucket = new ArrayList<HashMapNode<K, V>>();
        this.capacity = INITIAL_CAPACITY;
        // Below one is important step
        // if we are not adding element into the list, the list size will be zero(0)
        // only, that/s why we need to add null.
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % capacity;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashMapNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        HashMapNode<K, V> newEntry = new HashMapNode<K, V>(key, value);
        head = bucket.get(bucketIndex);
        newEntry.next = head;
        bucket.set(bucketIndex, newEntry);

        double loadFactor = (1.0 * size) / capacity;
        System.out.println("inserting key : " + key);
        System.out.println("load factor : " + loadFactor);
        if (loadFactor > 0.7) {
            rehash();
        }
    }

    private void rehash() {
        System.out.println("Rehashing buckets");
        List<HashMapNode<K, V>> temp = bucket;
        capacity *= 2;
        bucket = new ArrayList<HashMapNode<K, V>>();
        for (int i = 0; i < capacity; i++) {
            bucket.add(null);
        }
        size = 0;
        for (int i = 0; i < temp.size(); i++) {
            HashMapNode<K, V> head = temp.get(i);
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashMapNode<K, V> head = bucket.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashMapNode<K, V> head = bucket.get(bucketIndex);
        HashMapNode<K, V> previousNode = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (previousNode == null) {
                    bucket.set(bucketIndex, head.next);
                    return;
                } else {
                    previousNode.next = head.next;
                    head = null;
                    size--;
                    break;
                }
            }
            previousNode = head;
            head = head.next;
        }
    }

    private class HashMapNode<K, V> {
        K key;
        V value;
        HashMapNode<K, V> next;

        public HashMapNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}

public class HasnMapImplementationRevision {
    public static void main(String[] args) {
        HashMapImplRevise<Integer, String> hashMap = new HashMapImplRevise<Integer, String>();
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

        hashMap.remove(1);
    }
}
