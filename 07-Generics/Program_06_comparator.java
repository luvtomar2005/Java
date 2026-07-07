import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {

    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    /**
     * Natural Ordering
     * Sort students based on ID (Ascending Order)
     */
    @Override
    public int compareTo(Student other) {

        System.out.println("--------------------------------");
        System.out.println("Comparing");
        System.out.println(this.name + " (" + this.id + ")");
        System.out.println(other.name + " (" + other.id + ")");

        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}


public class Program_06_comparator {
    public static void main(String[] args) {
        
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(103, "Rahul", 88.5));
        students.add(new Student(101, "Amit", 91.2));
        students.add(new Student(105, "Neha", 76.8));
        students.add(new Student(102, "John", 85.0));
        students.add(new Student(104, "Riya", 95.4));

        System.out.println("Before Sorting");
        System.out.println("-----------------------");

        for (Student student : students) {
            System.out.println(student);
        }

        Collections.sort(students);

        System.out.println();
        System.out.println("After Sorting (By ID)");
        System.out.println("-----------------------");

        for (Student student : students) {
            System.out.println(student);
        }
    }

}
