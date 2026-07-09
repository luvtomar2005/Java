import java.util.List;
public class Program_01_Stream{
    public static void main(String [] args){
        List<Integer> numbers = List.of(1,2,3,4,5,6);
        numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 10).forEach(System.out::println);
    }
}
