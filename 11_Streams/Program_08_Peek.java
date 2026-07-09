import java.util.List;

public class Program_08_Peek {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1 , 2,3,4);
        numbers.stream().peek(number -> System.out.println("Original :" + number))
        .map(number -> number * 10).peek(number -> System.out.println("Mapped : " + number))
        .forEach(System.out::println);
    }
}

