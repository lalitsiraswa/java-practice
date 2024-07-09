import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Student {
    private Integer rollNo;
    private Integer totalScore;

    public Student(Integer rollNo, Integer totalScore) {
        this.rollNo = rollNo;
        this.totalScore = totalScore;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

}

public class RadisysTest {
    public static void main(String[] args) {
        Student s1 = new Student(101, 100);
        Student s2 = new Student(102, 100);
        Student s3 = new Student(101, 99);
        Student s4 = new Student(102, 99);
        Student s5 = new Student(101, 90);
        Student s6 = new Student(102, 90);
        Student s7 = new Student(101, 80);
        Student s8 = new Student(102, 80);
        List<Student> students = List.of(s1, s2, s3, s4, s5, s6, s7, s8);
        // Map<Integer, ArrayList<Student>> studentMap = new TreeMap<Integer,
        // ArrayList<Student>>(
        // Comparator.reverseOrder());
        // for (Student stu : students) {
        // if (studentMap.containsKey(stu.getTotalScore())) {
        // ArrayList<Student> existingStudents = studentMap.get(stu.getTotalScore());
        // existingStudents.add(stu);
        // System.out.println(existingStudents);
        // studentMap.put(stu.getTotalScore(), existingStudents);
        // } else {
        // studentMap.put(stu.getTotalScore(), new ArrayList<Student>(List.of(stu)));
        // }
        // }
        // --------------
        Map<Integer, List<Student>> studentMap = new TreeMap<Integer, List<Student>>(
                Comparator.reverseOrder());
        for (Student stu : students) {
            if (studentMap.containsKey(stu.getTotalScore())) {
                // List<Student> existingStudents = new
                // ArrayList<Student>(studentMap.get(stu.getTotalScore()));
                List<Student> existingStudents = studentMap.get(stu.getTotalScore());
                existingStudents.add(stu);
                System.out.println(existingStudents);
                studentMap.put(stu.getTotalScore(), existingStudents);
            } else {
                studentMap.put(stu.getTotalScore(), new ArrayList<Student>(List.of(stu)));
            }
        }
        int n = 2;
        int i = 0;
        for (Map.Entry<Integer, List<Student>> entry : studentMap.entrySet()) {
            i += 1;
            if (i == n) {
                for (Student student : entry.getValue()) {
                    System.out.println(student.getRollNo() + " : " + student.getTotalScore());
                }
            }
        }
    }
}
