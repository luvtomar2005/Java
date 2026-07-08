// import java.util.function.Function;
import java.util.function.Function;
/**
 * Program_06_Function_FI
 */
public class Program_06_Function_FI {

    public static void main(String[] args) {
        Function<String , Integer> length = name -> name.length();
        System.out.println(length.apply("JAVA"));
    }
}