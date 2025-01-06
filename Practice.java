import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private Integer rollNo;
    private Integer englishMarks;
    private Integer mathsMarks;
    private Integer physicsMarks;

    public Student(String name, Integer rollNo, Integer englishMarks, Integer mathsMarks, Integer physicsMarks) {
        this.name = name;
        this.rollNo = rollNo;
        this.englishMarks = englishMarks;
        this.mathsMarks = mathsMarks;
        this.physicsMarks = physicsMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public Integer getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(Integer englishMarks) {
        this.englishMarks = englishMarks;
    }

    public Integer getMathsMarks() {
        return mathsMarks;
    }

    public void setMathsMarks(Integer mathsMarks) {
        this.mathsMarks = mathsMarks;
    }

    public Integer getPhysicsMarks() {
        return physicsMarks;
    }

    public void setPhysicsMarks(Integer physicsMarks) {
        this.physicsMarks = physicsMarks;
    }
}

enum Day {
    MONDAY("Start of the week"),
    TUESDAY("Second day"),
    WEDNESDAY("Midweek"),
    THURSDAY("Almost there"),
    FRIDAY("Weekend is near"),
    SATURDAY("Relax day"),
    SUNDAY("Prep for Monday");

    private String description;

    // Constructor
    Day(String description) {
        this.description = description;
    }

    // Getter
    public String getDescription() {
        return description;
    }
}

public class Practice {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rajiv", 1, 78, 76, 80));
        students.add(new Student("Ankit", 2, 65, 83, 57));
        students.add(new Student("Praveen", 3, 54, 83, 59));
        students.add(new Student("Kaishav", 4, 75, 89, 79));
        students.add(new Student("Rajesh", 5, 65, 70, 68));

        // students.stream().map(student ->
        // student.getName()).forEach(System.out::println);
        for (Day day : Day.values()) {
            System.out.println(day + ": " + day.getDescription());
        }
    }
}
