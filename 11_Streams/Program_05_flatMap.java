import java.util.List;

public class Program_05_flatMap {

    public static void main(String[] args) {
        List<List<Integer>> numbers = List.of(
            List.of(1, 2),
            List.of(3 , 4),
            List.of(5 , 6)
        );
        numbers.stream().flatMap(List::stream).forEach(System.out::println);
    }
}

