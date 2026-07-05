public record Student(int id, String name, int age) {
}

public class Program_08_record {
    public static void main(String[] args) {
        Student student = new Student(101, "Luv", 21);

        System.out.println(student);

        System.out.println(student.id());

        System.out.println(student.name());

        System.out.println(student.age());
    }
}
