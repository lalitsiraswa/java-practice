package ObjectOrientedProgrammingConcept;

class GFG {
    static String Employee_name;
    static float Employee_salary;

    static void set(String name, float salary) {
        Employee_name = name;
        Employee_salary = salary;
    }

    static void get() {
        System.out.println("Employee name is : " + Employee_name);
        System.out.println("Employee CTC us : " + Employee_salary);
    }
}

public class ClassExample {
    public static void main(String[] args) {
        GFG.set("Rathore Avinash", 2000000);
        GFG.get();
    }
}
