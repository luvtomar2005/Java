class Calculator{
    // method with 2 int parameters
    int add(int a , int b){
        return a + b;
    }
    // same method name but different numbers of parameters
    int add(int a, int b , int c){
        return a + b + c;
    }

    // same method different data types
    double add(double a , double b){
        return a + b;
    }
}

public class program_17_polymorphism_overloading {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(10, 20));

        System.out.println(c.add(10, 20, 30));

        System.out.println(c.add(5.5, 4.5));
    }
}


/* Polyrorphism -> one name , many forms
parameters → Method Overloading
*/

 
/* Method overloading means defining 
multiple methods with the same name in the same class but with different parameters. */


