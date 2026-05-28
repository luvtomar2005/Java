class Luv{
    int x; // Instance / member object variable
    int y; // Instance / member object variable
    void fun1(){
       
        System.out.println("5");
    }
    void fun2(){
        System.out.println("This is the second function");
    }
}

public class example_03 {
    public static void main(String[] args) {
        Luv l1 = new Luv();

        System.out.println("Hello world");
        System.out.println(l1.y); // Will print 0 because in java at garbage value we have zero
    }
}
