class Animal {

    public void makeNoise() {

        System.out.println("Animal makes a sound");

    }
}


class Dog extends Animal {

    @Override
    public void makeNoise() {

        System.out.println("Dog says Woof");

    }
}

public class Program_13_method_overiding {
    public static void main(String[] args) {
           Dog dog = new Dog();

        dog.makeNoise();

    }
}



/* Method overriding occurs when a child class provides its own implementation of a method already defined in the parent class using the same method signature. 
The method that executes is determined at runtime based on the actual object type.
 It is an example of runtime polymorphism. */