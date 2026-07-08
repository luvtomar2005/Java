
class Student{
    String name;
    Student(String name){
        this.name = name;

    }
}

public class Progam_04_HashCode {

    public static void main(String[] args) {
        Student s1 = new Student("Luv");
        Student s2 = new Student("Luv");
        System.out.println("s1 HashCodde : " + s1.hashCode());
        System.out.println("s2 hashCode : " + s2.hashCode());
    }
}

