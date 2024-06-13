import java.util.Optional;

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
    }
}
