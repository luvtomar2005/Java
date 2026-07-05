/* Method overloading is the process of defining multiple methods with the same name in the same class but with different parameter lists.
 The compiler decides which method to call based on the arguments provided.
 It is an example of compile-time polymorphism. */

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

public class Program_12_method_overloading {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(10, 20));

        System.out.println(calculator.add(10, 20, 30));

        System.out.println(calculator.add(10.5, 20.5));

    }
}