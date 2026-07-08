
import java.util.ArrayList;
import java.util.Collection;

public class Program_01{
    public static void  main(String [] args){
        Collection<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Oranage");
        System.out.println(fruits);
    }
}
// object -> ArratList
// Collection<String> -> refrence interface
// System.out.println -> call toString() of ArrayList<>