class Animal{
    private String type;
    private String size;
    private double weight;

    public Animal(String type, String size ,double weight){
            this.type = type;
            this.size = size;
            this.weight = weight;
            System.out.println("Animal Constructor Called");
    }
    // Methods
    public void move(String speed){
        System.out.println(type + "moves" + speed);
    }
    public void makeNoise(){
        System.out.println(type + "make some kind of noise");
    }
    public void displayInfo(){
        System.out.println("\n--------- Aninam Information ---------");
        System.out.println("Type" + type);
        System.out.println("Size"  + size);
        System.out.println("Weight " + weight + "kg");
    }
}

class Dog extends Animal{
    private String earShape;
    private String tailShape;

    public Dog(String size , double weight , String earShape , String tailShape){
        //call the parent consturctor
        super("Dog" , size , weight);
        this.earShape = earShape;
        this.tailShape = tailShape;

        System.out.println("Dog Constructor Called");
    }
    // Dog Specific methods
    public void wagTail(){
        System.out.println("Dog is wagging its tail");
    }
    @Override
    public void move(String speed){
        System.out.println();
        System.out.println("Dog is preparing for speeding ");

        super.move(speed);
        System.out.println("Dog is running happily");
    }
    // overriding parent's mehtod
    public void makeNoise(){
        System.out.println("Dog says : Woof Woff");
    }
     // Display dog details
    
    public void displayDogInfo() {

        displayInfo();

        System.out.println("Ear Shape  : " + earShape);
        System.out.println("Tail Shape : " + tailShape);
    }
}
public class Program_09_inheritance {
    public static void main(String[] args) {
        Dog germanShepherd =
                new Dog(
                        "Large",
                        35.5,
                        "Pointed",
                        "Bushy"
                );

        germanShepherd.displayDogInfo();

        germanShepherd.makeNoise();

        germanShepherd.move("fast");

        germanShepherd.wagTail();
    }
}

    
 

  

   
