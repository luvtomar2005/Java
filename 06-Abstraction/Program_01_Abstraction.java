abstract class Animal {
    private String type;
    private String size;
    private double weight;

    // Constructor
    public Animal(String type , String size , double weight){
        this.type = type;
        this.size = size;
        this.weight = weight;
        System.out.println("Animal Constructor Called ");
    }

    // Concrete method
    public void displayInfo(){
        System.out.println("\n-------- Animal Information");
        System.out.println("Type: " + type);
        System.out.println("Size: "  + size);
        System.out.println("Weight: " + weight);
    }

    // Concrete method 
    public void sleep(){
        System.out.println(type + " is Sleeping");
    }

    // Abstract Methods
    public abstract void move();
    public abstract void makeNoise();
}

class Dog extends Animal {
    private String breed;

    public Dog(String size , double weight , String breed ){
        super("Dog" , size , weight);
        this.breed = breed;
        System.out.println("Dog Constructor called ");
    }

    @Override
    public void move(){
        System.out.println("Dog runs on four legs."); // Fixed typo
    }

    @Override
    public void makeNoise(){
        System.out.println("Dog says: woof woof");
    }

    @Override
    public void displayInfo(){
        super.displayInfo(); // Fixed: Added 'super' to prevent StackOverflowError
        System.out.println("Breed: " + breed);
    }
}

class Fish extends Animal {
    private int gills;

    public Fish(String size , double weight , int gills ){
        super("Fish" , size , weight);
        this.gills = gills;
        System.out.println("Fish Constructor Called ");
    }

    @Override
    public void move(){
        System.out.println("Fish swims in water.");
    }

    @Override
    public void makeNoise(){
        System.out.println("Fish makes bubbling sounds.");
    }

    @Override
    public void displayInfo(){
        super.displayInfo(); // Fixed: Added 'super' to prevent StackOverflowError
        System.out.println("Number of Gills: " + gills );
    }
}

public class Program_01_Abstraction {
    public static void main(String [] args){
        Dog dog = new Dog("Large" , 35 , "German Shepherd");
        dog.displayInfo();
        dog.move();
        dog.makeNoise();
        
        System.out.println();
        
        Fish fish = new Fish("Small" , 2 , 4);
        fish.displayInfo();
        fish.move();
        fish.makeNoise();
    }    
}