public class program_08_wrapperClass {
    public static void main(String[] args) {
        int x = Integer.parseInt("123");
        System.out.println(x);

        Integer i1 = Integer.valueOf("1000001", 2);
        int z = i1.intValue();
        System.out.println(z);

        Double x1 = Double.valueOf("56");
        double y = x1.doubleValue();
        System.out.println(y);
    }
}

/* Wrapper Classes in Java Collections

In Java, wrapper classes are used to convert 
primitive data types (int, char, double, etc.) 
into objects so they can be stored and manipulated 
in the Collections Framework, which only works with objects.

Why this is necessary: Java collections like ArrayList, HashMap,
 and HashSet are designed to store object references in the heap.
  Primitives are stored directly on the stack and have no object 
  reference, so they cannot be added directly to collections.
   Wrapper classes like Integer, Character, and Double encapsulate 
   these 
primitives into objects, enabling their use in collections. */