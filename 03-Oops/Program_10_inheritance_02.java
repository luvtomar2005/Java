class Animal{
    private String type;
    private String size;
    private double weight;

    public Animal(){
        System.out.println("Animal Constructor Called");
    }
    public Animal(String type , String size , double weight){
        this.type = type;
        this.size = size;
        this.weight = weight;
        System.out.println("Animal Pareamterized Constructor ");
    }
    public void move(String speed){
        System.out.println(type + "moves" + speed);
    }
    public void makeNoise(){
        System.out.println(type + "makes some kind of noise");
    }
    public void displayInfo(){
        System.out.println("\n-------- Animal Information ----------");
        System.out.println("Type : "  + size );
        System.out.println("Weight " + weight);
    }
    public String getType(){
        return type;
    }
    public String getSize(){
        return size;
    }
    public double getWeight(){
        return weight;
    }
}
class Dog extends Animal{
    private String earShape;
    private String tailShape;

    public Dog(){
        super();
        System.out.println("Dog Default Constructor");
    }
    public Dog(String size , double weight , String earShape , String tailShape){
        super("Dog" , size , weight);
        this.earShape = earShape;
        this.tailShape = tailShape;

        System.out.println("Dog Parameterized Consturctor");
    }
    @Override
    public void makeNoise(){
        System.out.println("Dog Says Woof Woof");
    }
    @Override
    public void move(String speed) {

        System.out.println();

        System.out.println("Dog starts moving...");

        super.move(speed);

        System.out.println("Dog is running.");
    }
     public void displayDogInfo() {

        displayInfo();

        System.out.println("Ear Shape  : " + earShape);

        System.out.println("Tail Shape : " + tailShape);
    }
}



public class Program_10_inheritance_02 {
    public static void main(String[] args) {
         Dog germanShepherd =
                new Dog(
                        "Large",
                        35.5,
                        "Pointed",
                        "Bushy"
                );

        System.out.println();

        germanShepherd.displayDogInfo();

        System.out.println();

        germanShepherd.makeNoise();

        System.out.println();

        germanShepherd.move("Fast");

        System.out.println();

      
    }
}
   
