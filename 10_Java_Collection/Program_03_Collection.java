// import java.util.ArrayList;
// import java.util.Collection;
import java.util.ArrayList;
import java.util.Collection;

public class Program_03_Collection {

    public static void main(String[] args) {
        Collection<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("Initial : " + fruits);
        System.out.println("Sizes : " + fruits.size());
        System.out.println("Contains : " + fruits.contains("Banana"));
        fruits.remove("Banana");
        


         System.out.println("After Remove: " + fruits);

        // Check empty
        System.out.println("Is Empty? " + fruits.isEmpty());

        // Add another collection
        Collection<String> moreFruits = new ArrayList<>();
        moreFruits.add("Mango");
        moreFruits.add("Grapes");

        fruits.addAll(moreFruits);

        System.out.println("After addAll: " + fruits);

        // Clear everything
        fruits.clear();

        System.out.println("After Clear: " + fruits);

    }
}

