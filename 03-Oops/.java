// Parent Class
class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("Hi, I am a person.");
    }
}

// POJO Class
class Student extends Person {
    private int id;
    private int age;
    private String course;

    public Student() {
        super("Unknown");
    }

    public Student(int id, String name, int age, String course) {
        super(name);
        this.id = id;
        this.age = age;
        this.course = course;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    public void setId(int id) { this.id = id; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public void introduce() {
        System.out.println("Student Details");
        System.out.println("----------------");
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Course  : " + course);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + '\'' + ", age=" + age + ", course='" + course + '\'' + '}';
    }
}

// Driver Class
public class Program_07_pojo_annotation_overriden {

    public static void main(String[] args) {
        Student student = new Student(101, "Luv", 21, "Computer Science");
        student.introduce();
        System.out.println();
        System.out.println(student);
    }
} // <--- THIS WAS MISSING! This closes the driver class properly.