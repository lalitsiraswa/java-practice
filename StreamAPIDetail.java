import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIDetail {
    public static void main(String[] args) {
        // Creating Streams
        List<String> myList = Arrays.asList("apple", "banana", "orange");
        Stream<String> sequentialStream = myList.stream();
        Stream<String> parallStream = myList.parallelStream();
        // ----------- Creates a stream from an array
        int[] numbers = { 1, 2, 3, 4, 5 };
        IntStream intStream = Arrays.stream(numbers);
        // -----------------
        Stream<String> strStream = Stream.of("apple", "banana", "orange");
        // Intermeditate operations
        // ----------------- filter()
        List<String> filtered = myList.stream()
                .filter(s -> s.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(filtered);
        // ----------- map()
        // List<Integer> lengthList = myList.stream()
        // .map(str -> str.length())
        // .collect(Collectors.toList());
        List<Integer> lengthList = myList.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengthList);
        // -------- sorted()
        List<String> sortedList = myList.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedList);
        // -------- distinct()
        List<String> distiStrings = myList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distiStrings);
        // Terminal operations
        // -------- forEach()
        myList.stream().forEach(System.out::println);
        // -------- collect()
        // --------- count()
        long count = myList.stream().count();
        System.out.println(count);
    }
}
