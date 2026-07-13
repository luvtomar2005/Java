import java.io.*;

// Student class must implement Serializable
class Student implements Serializable {

    // Recommended for Serializable classes
    private static final long serialVersionUID = 1L;

    String name;
    int age;
    transient String password;   // Will NOT be serialized

    Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}

/**
 * Program_08_Serialization_Deserialization
 */
public class Program_08_Serialization_Deserialization {

    


    public static void main(String[] args) {

        // -------------------------------
        // Step 1 : Create Object
        // -------------------------------
        Student student = new Student("Luv", 21, "Java@123");

        // -------------------------------
        // Step 2 : Serialization
        // -------------------------------
        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("student.ser"))) {

            out.writeObject(student);

            System.out.println("✅ Object Serialized Successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        // -------------------------------
        // Step 3 : Deserialization
        // -------------------------------
        try (ObjectInputStream in =
                     new ObjectInputStream(
                             new FileInputStream("student.ser"))) {

            Student restoredStudent = (Student) in.readObject();

            System.out.println("✅ Object Deserialized Successfully!");
            System.out.println("Name      : " + restoredStudent.name);
            System.out.println("Age       : " + restoredStudent.age);
            System.out.println("Password  : " + restoredStudent.password);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}