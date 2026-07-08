// import java.util.ArrayList;
// import java.util.Collection;
import java.util.ArrayList;
import java.util.Collection;
/**
 * Program_02_Collection
 */
public class Program_02_Collection {

    public static void main(String[] args) {
        Collection<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Apple");
        fruits.add("Apple");
        System.out.println("Fruits : " + fruits);
        System.out.println("Fruits : " + fruits.size());
        System.out.println("Conatains Apple ? " + fruits.contains("Apple"));
        fruits.remove("Banana");

        System.out.println("Before removal " + fruits);
        fruits.clear();
        System.out.println("After Clear : " + fruits);
    }
}

