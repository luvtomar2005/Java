
import java.util.List;

public class Program_04_Stream_UpperCase {

    public static void main(String[] args) {
        List<String> names = List.of("Luv" , "Ram" , "Sita" , "Hanuman");
        names.stream().map(String :: toUpperCase).forEach(System.out::println);
    }
}
