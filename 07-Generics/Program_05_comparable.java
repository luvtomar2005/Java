import java.util.*;
class Student implements Comparable<Student> {
    private int id;
    private String name;
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public int compareTo(Student other){
        return this.id - other.id;
    }
    @Override
    public String toString() {
        return id + " - " + name;
    }
}

/**
 * Program_05_comparable
 */
public class Program_05_comparable {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(103 , "Rahul"));
        students.add(new Student(101 , "Luv"));
        students.add(new Student(190 , "Shobhit"));
        Collections.sort(students);
        System.out.println(students);
    }
}
