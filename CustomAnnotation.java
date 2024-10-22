// We’re going to create three custom annotations with the goal of serializing an object into a JSON string.
// We’ll use the first one on the class level, to indicate to the compiler that our object can be serialized. 
// Then we’ll apply the second one to the fields that we want to include in the JSON string.
// Finally, we’ll use the third annotation on the method level, to specify the method that we’ll use to initialize our object.

// The first step toward creating a custom annotation is to declare it using the @interface keyword:
// The next step is to add meta-annotations to specify the scope and the target of our custom annotation:

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface JsonSerializable {
}

// As we can see, our first annotation has runtime visibility, and we can apply
// it to types (classes). Moreover, it has no methods, and thus serves as a
// simple marker to mark classes that can be serialized into JSON.

// we create our second annotation to mark the fields that we are going to
// include in the generated JSON:

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonElement {
}

// Let’s imagine that before serializing an object to a JSON string, we want to
// execute some method to initialize an object. For that reason, we’re going to
// create an annotation to mark this method:

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Init {
}

// By setting the key parameter of the @JsonElement annotation to 'personAge,''
// we are indicating that we’ll use this name as the identifier for the field in
// the JSON output.
@JsonSerializable
class Person {
    @JsonElement
    private String firstName;

    @JsonElement
    private String lastName;

    @JsonElement()
    private String age;

    private String address;

    public Person(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

// So far we’ve seen how to create custom annotations, and how to use them to
// decorate the Person class. Now we’re going to see how to take advantage of
// them by using Java’s Reflection API.
class JsonSerializationException extends Exception {
    public JsonSerializationException(String message) {
        super(message);
    }
}

public class CustomAnnotation {
    // 1. The first step will be to check whether our object is null or not, as well
    // as whether its type has the @JsonSerializable annotation or not:
    private static void checkIfSerializable(Object object) throws JsonSerializationException {
        if (Objects.isNull(object)) {
            throw new JsonSerializationException("The object to serialize is null");
        }
        Class<?> clazz = object.getClass();
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new JsonSerializationException(
                    "The class " + clazz.getSimpleName() + " is not annotated with JsonSerializable");
        }
    }

    // 2. Then we look for any method with the @Init annotation, and we execute it
    // to initialize our object’s fields:
    private static void initializeObject(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    // After the initialization, we iterate over our object’s fields, retrieve the
    // key and value of JSON elements, and put them in a map. Then we create the
    // JSON string from the map:
    private static String getJsonString(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        Map<String, String> jsonElementsMap = new HashMap<String, String>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(field.getName(), (String) field.get(object));
            }
        }
        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));
        return "{" + jsonString + "}";
    }

    // Our JSON serializer class combines all the above steps:
    private static String convertToJson(Object object) throws Exception {
        try {
            checkIfSerializable(object);
            initializeObject(object);
            return getJsonString(object);
        } catch (Exception e) {
            throw new JsonSerializationException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Lalit", "Siraswa", "25");
        try {
            String jsonString = convertToJson(person);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
