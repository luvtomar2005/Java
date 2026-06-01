class Demo{
    int x, y;
    Demo(int p , int q){
       x = p;
       y = q;
    }
    Demo(){

    }
}

public class program_12_contructor_overloading {
    public static void main(String[] args) {
      // 1. Calls Constructor 1 (Matches the signature: two ints)
        Demo d1 = new Demo(5, 6); 
        System.out.println("d1.x: " + d1.x); // Outputs: 5
        System.out.println("d1.y: " + d1.y); // Outputs: 6

        // 2. Calls Constructor 2 (Matches the signature: no args)
        Demo d2 = new Demo(); 
        System.out.println("d2.x: " + d2.x); // Outputs: 0
        System.out.println("d2.y: " + d2.y); // Outputs: 0
    }   
}

/* Constructor overloading is the ability to define multiple constructors with the same name within a single class, as long as they have different parameter lists
 (different number of arguments, different data types, or a different sequence of types). */
