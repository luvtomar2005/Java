// import java.util.ArrayList;
// import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Program_06_List {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
                fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Original: " + fruits);

        System.out.println("Second Fruit: " + fruits.get(1));

        fruits.set(1, "Mango");

        System.out.println("After set(): " + fruits);

        fruits.add(1, "Grapes");

        System.out.println("After add(index): " + fruits);

        fruits.remove(2);

        System.out.println("After remove(index): " + fruits);

        System.out.println("Index of Orange: " + fruits.indexOf("Orange"));
    }
    }
