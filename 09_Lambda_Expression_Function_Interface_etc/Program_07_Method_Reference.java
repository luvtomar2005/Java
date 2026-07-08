import java.util.function.Function;
import java.util.function.Supplier;

class Student {

    public Student() {
        System.out.println("Student Created");
    }
}

public class Program_07_Method_Reference {
  public static void main(String[] args) {

        Function<String, Integer> length =
                String::length;

        System.out.println(length.apply("Spring"));

        Supplier<Student> supplier =
                Student::new;

        supplier.get();
    }
    
}
