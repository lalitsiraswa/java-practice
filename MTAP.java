import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MTAP {
    public static void numberPrint(int number) {
        if (number >= 11) {
            return;
        }
        System.out.println(number);
        numberPrint(number + 2);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Hello!");
        } finally {
            System.out.println("World!");
        }

        // --------------------------------------------
        // List<Integer> numList = new ArrayList<>(List.of(4, 3, 1, 2, 9, 8, 6, 7));
        // int totalSum = 0;
        // for (int i = 1; i <= numList.size() + 1; i++) {
        // totalSum += i;
        // }
        // int totalElementSum = 0;
        // for (int i = 0; i < numList.size(); i++) {
        // totalElemmentSum += numList.get(i);
        // }
        // System.out.println(totalSum - totalElementSum);

        // String str1 = "Lalit";
        // String str2 = new String("Lalit");
        // System.out.println(str1.equals(str2));
        // ------------------------------------------------------------------------
        // Collections.sort(numList);
        // for (int i = 0; i < numList.size(); i++) {
        // if (i + 1 != numList.get(i)) {
        // System.out.println(i + 1);
        // break;
        // }
        // }
        // -----------------------------------------------------------------------
        // numberPrint(2);
        // ------------------------------------------------------------------------
        String name = "Lalit";
        name = name.toLowerCase();
        System.out.println(name);
        // Map<Character, Integer> charCounter = new HashMap<Character, Integer>();
        // for (int i = 0; i < name.length(); i++) {
        // charCounter.put(Character.toLowerCase(name.charAt(i)),
        // charCounter.getOrDefault(Character.toLowerCase(name.charAt(i)), 0) + 1);
        // }
        // for (char ch : charCounter.keySet()) {
        // System.out.println(ch + " : " + charCounter.get(ch));
        // }
    }
}
