import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Streams don’t change the original data structure, they only provide the result as per the pipelined methods.
public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream stream = list.stream();
        System.out.println(stream);
        // ------------------
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(2);
        al.add(6);
        al.add(9);
        al.add(4);
        al.add(20);
        System.out.println("Printing the collection : " + al);
        List<Integer> ls = al.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Printing the List after stream operation : " + ls);
    }
}
