// Using HashMap

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class HashMapDemo extends Thread {
    static HashMap<Integer, String> map = new HashMap<Integer, String>();

    HashMapDemo(String threadname) {
        super(threadname);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - START");
        try {
            Thread.sleep(1000);
            // Child thread trying to add
            // new element in the object
            map.put(105, "E");
        } catch (InterruptedException e) {
            System.out.println("Child Thread going to add element!");
        }
        System.out.println(Thread.currentThread().getName() + " - END");
    }
}

class ConHashMapDemo extends Thread {
    static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();

    ConHashMapDemo(String threadname) {
        super(threadname);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - START");
        try {
            Thread.sleep(1000);
            // Child thread trying to add
            // new element in the object
            map.put(105, "E");
        } catch (InterruptedException e) {
            System.out.println("Child Thread going to add element!");
        }
        System.out.println(Thread.currentThread().getName() + " - END");
    }
}

public class HashMapAndConcurrentHashMap {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " - START");
        // HashMapDemo hashMapDemo = new HashMapDemo("Child-Thread");
        // hashMapDemo.map.put(100, "A");
        // hashMapDemo.map.put(101, "B");
        // hashMapDemo.map.put(103, "C");
        // hashMapDemo.map.put(104, "D");
        // hashMapDemo.start();
        // for (Map.Entry<Integer, String> entry : hashMapDemo.map.entrySet()) {
        // System.out.println(entry.getKey() + " : " + entry.getValue());
        // // hashMapDemo.map.put(105, "E");
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // }
        // ----------------
        ConHashMapDemo hashMapDemo = new ConHashMapDemo("Child-Thread");
        ConHashMapDemo.map.put(100, "A");
        ConHashMapDemo.map.put(101, "B");
        ConHashMapDemo.map.put(103, "C");
        ConHashMapDemo.map.put(104, "D");
        hashMapDemo.start();
        for (Map.Entry<Integer, String> entry : hashMapDemo.map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            // hashMapDemo.map.put(105, "E");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " - END");
    }
}
