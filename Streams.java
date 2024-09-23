import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Printing the collection : " + numList);
        System.out.println();
        List<Integer> evenNum = numList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println("Printing the list after stream operation : " + numList);
        System.out.println("Printing the even list after stream operation : " + evenNum);
    }
}
