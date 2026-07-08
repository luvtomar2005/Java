// import java.util.function.Supplier;
import java.util.function.Supplier;

/**
 * Program_05_Supplier_FI
 */
public class Program_05_Supplier_FI {

    public static void main(String[] args) {
        Supplier<String> greeting = () -> "Welcome";
        System.out.println(greeting.get());
    }
}
