@FunctionalInterface 
interface Greeting {
    void greet();
}

/**
 * Program_02_Functional_Interface
 */
public class Program_02_Functional_Interface {

    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("Hello Java");
        greeting.greet();
    }
}
