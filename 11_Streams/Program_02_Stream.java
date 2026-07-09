import java.util.stream.*;
import java.util.*;


public class Program_02_Stream {

    public static void main(String[] args) {
        List<String> names = List.of("Ram" , "Shyam" , "Mohan");
        names.stream().forEach(System.out::println);
        System.out.println();
        String [] languages = {"Java " , "Spring " , "Hibernate"};
        Arrays.stream(languages).forEach(System.out::println);
        System.out.println();
        Stream.of("A" , "B" , "C").forEach(System.out::println);
        System.out.println();
        Stream.generate(() -> "Hello").limit(3).forEach(System.out::println);
        System.out.println();
        Stream.iterate(1 , n -> n + 1).limit(5).forEach(System.out::println);
        System.out.println();
        IntStream.range(1 , 5).forEach(System.out::println);
    }
}

