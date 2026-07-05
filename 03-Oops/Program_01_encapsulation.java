public class Program_01_encapsulation {

    // Private field (Data Hiding)
    private String name;

    // Setter Method
    public void setName(String name) {
        this.name = name;
    }

    // Getter Method
    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        // Creating an object of the same class
        Program_01_encapsulation student = new Program_01_encapsulation();

        // Setting the name
        student.setName("Luv");

        // Getting the name
        System.out.println(student.getName());
    }
}

/*
 * Encapsulation is the process of bundling data (fields)
 * and the methods that operate on that data into a single
 * unit (a class), while restricting direct access to the
 * data using access modifiers such as private.
 *
 * The internal data is accessed through public methods
 * (such as getters and setters), allowing validation,
 * security, and better maintainability.
 */