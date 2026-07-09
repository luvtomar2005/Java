import java.util.Comparator;
import java.util.List;
/**
 * Program_07_Sorted
 */
public class Program_07_Sorted {

    public static void main(String[] args) {
        List<String> names = List.of("Rahul " , "Amit" , "Neha" , "Akash");
        names.stream().sorted().forEach(System.out::println);
        System.out.println();
        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
