import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class QueueInterface {
    public static void main(String[] args) {
        System.out.println("\n------------- Priority Queue -----------------");
        // Java program to demonstrate the working of
        // priority queue in Java
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for (int i = 1; i <= 4; i++)
            pQueue.add(i * 10);
        System.out.println(pQueue.peek());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.peek());

        System.out.println("\n------------- Deque Interface 'ArrayDeque' -----------------");
        ArrayDeque<Integer> deQueqe = new ArrayDeque<Integer>();
        for (int i = 1; i <= 5; i++)
            deQueqe.add(i * 10);
        System.out.println(deQueqe);
        deQueqe.clear();
        deQueqe.addFirst(10);
        deQueqe.addFirst(20);
        deQueqe.addLast(30);
        deQueqe.addLast(40);
        System.out.println(deQueqe);
    }
}
