import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Creating annotation  
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    int value();
}

// Applying annotation
class Demo {
    @MyAnnotation(value = 10)
    public void sayHello() {
        System.out.println("Hello Annotation!");
    }
}

public class CustomAnnotation {
    public static void accessAnnotation() {
        try {
            // Accessing annotation
            Demo demo = new Demo();
            Method method = demo.getClass().getMethod("sayHello");
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);

            // Display the value of the annotation
            if (annotation != null) {
                System.out.println("Annotation value: " + annotation.value());
            } else {
                System.out.println("Annotation not present.");
            }
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        accessAnnotation();
    }
}
