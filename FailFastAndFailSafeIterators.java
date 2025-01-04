// The main distinction between fail-fast and fail-safe iterators is whether or not the collection can be modified while it is being iterated. Fail-safe iterators allow this; fail-fast iterators do not.

// 1. Fail-fast iterators operate directly on the collection itself. During iteration, fail-fast iterators fail as soon as they realize that the collection has been modified (i.e., upon realizing that 
// a member has been added, modified, or removed) and will throw a ConcurrentModificationException. Some examples include ArrayList, HashSet, and HashMap (most JDK1.4 collections are implemented to be
//  fail-fast).

// 2. Fail-safe iterates operate on a cloned copy of the collection and therefore do not throw an exception if the collection is modified during iteration. Examples would include iterators returned by 
// ConcurrentHashMap or CopyOnWriteArrayList.

// Direct Index-Based Access in For Loop:
// You're iterating the list using a basic for loop with an index (for (int i = 0; i < integers.size(); i++)). This type of loop accesses elements by index 
// and doesn't use an iterator. Since a ConcurrentModificationException typically occurs when you modify a collection while using an iterator (e.g., 
// with a for-each loop or explicitly using Iterator), your code avoids this exception.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastAndFailSafeIterators {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        integers.add(5);
        // for (int i = 0; i < integers.size(); i++) {
        // integers.add(i, i * 2);
        // System.out.println(integers.get(i));
        // }
        // ---------------------
        for (Integer item : integers) {
            // java.util.ConcurrentModificationException
            // integers.add(item * 2);
            System.out.println(item);
        }
    }
}