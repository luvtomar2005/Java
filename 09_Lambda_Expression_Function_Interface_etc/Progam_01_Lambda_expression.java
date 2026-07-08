
interface Animal {
    void sound();
}

/**
 * Progam_01_Lambda_expression
 */
public class Progam_01_Lambda_expression {

    public static void main(String[] args) {
        Animal animal = () -> System.out.println("Dog Barks ");
        animal.sound();
    }

}

