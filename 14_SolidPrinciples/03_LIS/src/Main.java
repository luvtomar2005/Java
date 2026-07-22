// Objects of a superclass should be replaceable with objects of its subclasses without altering the correctness of the program.

public class Main {

    public static void main(String[] args) {

        Zoo zoo = new Zoo();

        Sparrow sparrow = new Sparrow();
        Penguin penguin = new Penguin();

        System.out.println("---- Eating ----");

        zoo.makeBirdEat(sparrow);
        zoo.makeBirdEat(penguin);

        System.out.println();

        System.out.println("---- Flying ----");

        zoo.makeBirdFly(sparrow);

        // zoo.makeBirdFly(penguin);
        // Compile-time Error
        // Penguin is not Flyable

    }

}