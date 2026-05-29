class A{
    int x;
    private static int y;
    void fun1(){
        y = 22;
    }
    void fun2(){
        System.out.println(y);
    }
    void fun3(){
        y = 45;
    }
}

public class program_06 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();

        a1.fun1();
        a2.fun3();
        a1.fun2();
    }
}

/* explanation for 45 is Why does a2.fun2() or a1.fun2() both work? 
Because y is static. It doesn't matter which object calls the print method; 
they both read from the exact same shared slot in memory.

The Rule of Static Manipulation: The value of a static variable always reflects the most recent change made by any method or object. 

To catch a specific value, you must print it before another operation changes it. */
