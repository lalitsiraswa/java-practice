import java.util.Arrays;
import java.util.List;

public class ListofVsArraysasList {
    public static void main(String[] args) {
        List<String> immutable_list = List.of("apple", "banana", "orange", "pineapple");
        List<String> mutable_list = Arrays.asList("red", "green", "yellow", "black");
        // ------------
        String[] colorArray = { "Red", "Green", "Blue" };
        List<String> colors = List.of(colorArray);

        colorArray[0] = "Yellow";
        // colors.add("Brown"); // Exception in thread "main"
        // java.lang.UnsupportedOperationException
        // colors.remove(1);// Exception in thread "main"
        // java.lang.UnsupportedOperationException

        System.out.println(colors.get(0).equals(colorArray[0]));
        System.out.println(colors.get(1).equals(colorArray[1]));
        System.out.println(colors.get(2).equals(colorArray[2]));

        // -------------------
        List<String> colorsList = Arrays.asList(colorArray);
        colorsList.set(0, "Brown");
        // colorsList.add("White"); // Exception in thread "main"
        // java.lang.UnsupportedOperationException
        System.out.println(colorsList.get(0).equals(colorArray[0]));
        System.out.println(colorsList.get(1).equals(colorArray[1]));
        System.out.println(colorsList.get(2).equals(colorArray[2]));
    }
}
