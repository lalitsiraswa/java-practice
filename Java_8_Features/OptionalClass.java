package Java_8_Features;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        String[] words = new String[10];
        // Exception in thread "main" java.lang.NullPointerException
        // String word = words[5].toLowerCase();
        // System.out.println(word);

        // The above program using Optional Class
        Optional<String> checkNull = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.println(word);
        } else
            System.out.println("word is null");

        // -----------------------
        String[] str = new String[5];
        str[2] = "Geeks Classes are coming soon";
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        Optional<String> value = Optional.of(str[2]);
        System.out.println(value);
        // -----------------------
        System.out.println(value.get());
        System.out.println(value.hashCode());
        System.out.println(value.isPresent());
    }
}
