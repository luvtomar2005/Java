import java.util.List;

/**
 * Program_03_Stream
 */
public class Program_03_Stream {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(5 , 10 , 20 , 25 , 30);
        numbers.stream().filter(n -> n >= 20).forEach(System.out::println);
    }
}
