// import java.util.List;
import java.util.List;
/**
 * Program_06_Distinct
 */
public class Program_06_Distinct {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 10 , 20 , 20);
        numbers.stream().distinct().forEach(System.out::println);
    }
}