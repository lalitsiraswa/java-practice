import java.util.Arrays;

// A negative integer if the current object is less than the specified object.
// Zero if the current object is equal to the specified object.
// A positive integer if the current object is greater than the specified object.
class Pair implements Comparable<Pair> {
    String x;
    int y;

    public Pair(String x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair [x=" + x + ", y=" + y + "]";
    }

    @Override
    public int compareTo(Pair o) {
        // if the string are not equal
        if (this.x.compareTo(o.x) != 0) {
            return this.x.compareTo(o.x);
        } else {
            // we compare int values
            // if the strings are equal
            return this.y - o.y;
        }
    }

    // sort the array in ascending Lexicographical order of the first name and if
    // two strings are the same sort it based on their last name.

    // @Override
    // public int compareTo(Pair a) {
    // // if the string are not equal
    // if (this.firstName.compareTo(a.firstName) != 0) {
    // return this.firstName.compareTo(a.firstName);
    // } else {
    // // we compare lastName if firstNames are equal
    // return this.lastName.compareTo(a.lastName);
    // }
    // }
}

public class ComparableExplain {
    public static void main(String[] args) {
        Pair arr[] = new Pair[4];
        arr[0] = new Pair("abc", 3);
        arr[1] = new Pair("a", 4);
        arr[2] = new Pair("bc", 5);
        arr[3] = new Pair("a", 2);

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
