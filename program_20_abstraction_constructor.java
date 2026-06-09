abstract class Animal {

    Animal() {
        System.out.println("Animal constructor called");
    }

    abstract void sound();
}

class Dog extends Animal {

    Dog() {
        System.out.println("Dog constructor called");
    }

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}


public class program_20_abstraction_constructor {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}



/* When child object is created:

Dog d = new Dog();
the child object ALSO contains the parent part.
A Dog object is not only Dog.
It internally contains:
Animal part + Dog part
So Java must initialize BOTH parts.That is why parent constructor runs. */

/* Monst important interview question does abstraction have constructor 
yes abstract classes have constructor 
*/


/* One more abstract class question can we create main method inside abstract class
yes Because:
main() is static
Static methods belong to class, not object.
So no object creation is needed.
*/

