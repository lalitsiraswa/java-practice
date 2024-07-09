import java.util.Optional;

import javax.swing.text.html.Option;

public class OptionalClass {
    public static void main(String[] args) {
        // String[] str = new String[5];
        // str[2] = "Geeks Classes are coming soon";
        // Optional<String> empty = Optional.empty();
        // System.out.println(empty);
        // Optional<String> value = Optional.of(str[2]);
        // System.out.println(value);
        // -------------------
        String[] str = new String[5];
        str[2] = "Geeks Classes are coming soon";
        Optional<String> value = Optional.of(str[2]);
        // It returns value of an Optional.
        // If value is not present, it throws
        // an NoSuchElementException
        System.out.println(value.get());
        // value = Optional.empty();
        // System.out.println(value.get());

        // It returns hashCode of the value
        System.out.println(value.hashCode());

        // It returns true if value is present,
        // otherwise false
        System.out.println(value.isPresent());
        // ---------- Optional ofNullable() method
        Optional<Integer> op1 = Optional.ofNullable(12345);
        System.out.println("Optional 1 : " + op1);
        Optional<String> op2 = Optional.ofNullable(null);
        System.out.println("Optional 2 : " + op2);
        // ----------- Optional orElse() method
        Optional<Integer> op3 = Optional.of(4567);
        System.out.println("Optional 3 : " + op3);
        System.out.println("Value by orElse (100) method : " + op3.orElse(100));
        op3 = op3.empty();
        System.out.println("Value by orElse (100) method : " + op3.orElse(100));
        System.out.println("***************************");
        String[] words = new String[10];
        // String word = words[5].toLowerCase();
        // System.out.println(word);
        words[5] = "Lalit";
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.println(word);
            System.out.println(checkNull.get());
        } else {
            System.out.println("words is null");
        }
    }
}
