class Demo{
    int x, y;
    Demo(){
        x = 5;
        y = 6;
    }
}

public class program_12_constructor {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        System.out.println(d1.x);
        System.out.println(d1.y);
    }
}

// A constructor is a special method used to initialize objects, 
// and it is called automatically the exact moment an object is created.

/* If you do not write any constructor in a class, 
Java secretly inserts a blank one for you behind the scenes (a default constructor) */

