import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Printing the collection : " + numList);
        System.out.println();
        List<Integer> evenNum = numList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("Printing the list after stream operation : " + numList);
        System.out.println("Printing the even list after stream operation : " + evenNum);
        // --------------------------------------
        List<Integer> marks = new ArrayList<>(List.of(30, 78, 26, 96, 79));
        System.out.println("Marks fo students before grace : " + marks);
        // Now we want to grace marks by 6 using the streams to process over processing
        // collection
        // Using stream, we map every object and later collect to List and store them
        List<Integer> updatedMarks = marks.stream().map(x -> x + 9).collect(Collectors.toList());
        System.out.println();
        System.out.println("Marks of students after grace : " + updatedMarks);

        // ---------------- Terminal Operations ----------------
        List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);
        // Sort in ascending order
        list.stream().sorted().forEach(System.out::println);
        System.out.println();
        // sort in descending order
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println();
        Stream<String> stream = Stream.of("GFG", "Geeks", "For", "GeeksForGeeks");
        stream.sorted(Comparator.reverseOrder())
                .flatMap(str -> Stream.of(str.charAt(1)))
                .forEach(System.out::println);
        System.out.println();
        Stream<Integer> stream2 = Stream.of(5, 6, 7, 8, 9, 10);
        Object[] arr = stream2.toArray();
        System.out.println(Arrays.toString(arr));
        Stream<String> stream3 = Stream.of("Geeks", "For", "Geeks", "GeeksQuiz");
        Object[] arrObjects = stream3.toArray();
        System.out.println(Arrays.toString(arrObjects));
        Stream<String> stream4 = Stream.of("Geeks", "For", "Geeks", "GeeksQuiz");
        Object[] arrObjects2 = stream4.filter(str -> str.startsWith("G")).toArray();
        System.out.println(Arrays.toString(arrObjects2));

        List<String> strList = new ArrayList<>(List.of("Lalit", "Jaydeep", "Sanam"));
        strList.stream().forEach(System.out::println);

        Stream<String> names = Stream.of("Lalit", "Jaydeep", "Mayur", "Priya", "Sanam");
        names.forEach(System.out::println);
        // Exception in thread "main" java.lang.IllegalStateException: stream has
        // already been operated upon or closed
        // names.forEach(System.out::println);
    }
}
