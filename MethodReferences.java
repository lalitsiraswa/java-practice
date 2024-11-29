import java.util.List;
import java.util.function.Function;

public class MethodReferences {
    public static void main(String[] args) {
        // In Java 8 we can use the method as if they were objects or primitive values,
        // and we can treat them as a variable.
        Function<Integer, Integer> getSquare = i -> i * i;
        System.out.println(getSquare.apply(4));
        // ----------------------
        List<Integer> numList = List.of(1, 2, 3, 4, 5);
        numList.forEach(System.out::println);
    }
}
