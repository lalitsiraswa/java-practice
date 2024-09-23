import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface FuncInterface {
    void abstractFun(int x);

    default void normalFun() {
        System.out.println("Hello World!");
    }
}

class Test implements FuncInterface {
    public void abstractFun(int x) {
        System.out.println(x);
    }
}

@FunctionalInterface
interface FuncInter1 {
    int operation(int a, int b);
}

public class LambdaExpressions {
    public static void main(String[] args) {
        FuncInterface fObj = (int x) -> System.out.println(2 * x);
        fObj.abstractFun(5);
        FuncInterface fObj2 = (int x) -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i * x);
            }
            System.out.println();
        };
        fObj2.abstractFun(2);
        // -------------------------------
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4));
        arrayList.forEach(x -> System.out.println(x));
        // ------- Lambda Expression with multiple arguments -------
        System.out.println();
        FuncInter1 add = (a, b) -> a + b;
        FuncInter1 multiply = (a, b) -> a * b;
        System.out.println(add.operation(6, 3));
        System.out.println(multiply.operation(4, 5));
    }
}
