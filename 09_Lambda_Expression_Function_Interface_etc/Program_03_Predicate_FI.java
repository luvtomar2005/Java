// import java.util.function.Predicate;
import java.util.function.Predicate;

/**
 * Program_03_Predicate_FI
 */
public class Program_03_Predicate_FI {

    public static void main(String[] args) {
        Predicate<Integer> isAdult = age -> age >= 18;
        System.out.println(isAdult.test(19));
        System.out.println(isAdult.test(12));
    }
}
