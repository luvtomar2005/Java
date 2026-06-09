class Animal{
    void sound(){
        System.out.println("Animal makes sound");
    }
}

class Dog extends  Animal{
    @Override
    void sound(){
        System.out.println("Dog barks");
    }
}

class Cat extends Animal{
    @Override
    void sound(){
        System.out.println("Cat meows");
    }
}


public class program_18_polymorphism_overriding {
    public static void main(String[] args) {
        
         Animal a1 = new Dog();

        Animal a2 = new Cat();

        a1.sound();

        a2.sound();
    }   
}




/* Polymorphism is NOT overloading or overriding.
Those are just mechanisms to achieve it.
The actual idea is:
Same method/interface/action behaving differently in different situations. */