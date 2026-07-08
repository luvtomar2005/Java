// import java.util.function.Consumer;
import java.util.function.Consumer;

/**
 * Program_04_Consumer
 */
public class Program_04_Consumer {

    public static void main(String[] args) {
        Consumer<String> printer = name -> System.out.println(name);
        printer.accept("Luv");
    }
}
