// import java.util.ArrayList;
// import java.util.Iterator;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Program_05_Iterator
 */
public class Program_05_Iterator {

    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        // Getting  an interator from the iterable object
        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}