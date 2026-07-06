abstract class Appliance {
    private String brand;
    private int power;
    public Appliance(String brand, int power){
        this.brand = brand;
        this.power = power;
        System.out.println("Appliance Constructor Called ;  ");
    }
    public void turnOn(){
        System.out.println(brand + " appliance is now ON.");
    }
    public void turnOff(){
        System.out.println(brand + " appliance is now OFF . ");
    }
    public void displayInfo(){
        System.out.println("\n---------- Appliance Details -------");
        System.out.println("Brand : " + brand);
        System.out.println("Power " + power + " Watts ");
    }

    public abstract void performFunction();
    public abstract void maintenance();
}

class WashingMachine extends Appliance {
    private int drumCapacity;
    public WashingMachine(String brand, int power , int drumCapacity){
        super(brand, power);
        this.drumCapacity = drumCapacity;
        System.out.println("Washing machine Constructor Called ; ");
    }
    @Override
    public void performFunction(){
        System.out.println("Washing Clothes : ");
    }
    @Override
    public void maintenance(){
        System.out.println("Cleaning the drum... ");
    }
    public void displayMachine(){
        displayInfo();
        System.out.println("Drum Capacity : " + drumCapacity + " Kg");
    }
}


class Refrigerator extends Appliance {

    private int temperature;

    public Refrigerator(String brand,
                        int power,
                        int temperature) {

        super(brand, power);

        this.temperature = temperature;

        System.out.println("Refrigerator Constructor Called");
    }

    @Override
    public void performFunction() {
        System.out.println("Cooling food items...");
    }

    @Override
    public void maintenance() {
        System.out.println("Defrosting refrigerator.");
    }

    public void displayRefrigerator() {

        displayInfo();

        System.out.println("Temperature : " +
                temperature + "°C");
    }
}


// ===============================
// Air Conditioner
// ===============================

class AirConditioner extends Appliance {

    private int roomTemperature;

    public AirConditioner(String brand,
                          int power,
                          int roomTemperature) {

        super(brand, power);

        this.roomTemperature = roomTemperature;

        System.out.println("Air Conditioner Constructor Called");
    }

    @Override
    public void performFunction() {
        System.out.println("Cooling the room...");
    }

    @Override
    public void maintenance() {
        System.out.println("Cleaning air filters.");
    }

    public void displayAC() {

        displayInfo();

        System.out.println("Room Temperature : " +
                roomTemperature + "°C");
    }
}

public class Program_02_Abstraction {

    public static void main(String[] args) {
        WashingMachine washingMachine =
                new WashingMachine(
                        "LG",
                        1200,
                        8
                );

        washingMachine.displayMachine();
        washingMachine.turnOn();
        washingMachine.performFunction();
        washingMachine.maintenance();
        washingMachine.turnOff();

        System.out.println();

        Refrigerator refrigerator =
                new Refrigerator(
                        "Samsung",
                        250,
                        4
                );

        refrigerator.displayRefrigerator();
        refrigerator.turnOn();
        refrigerator.performFunction();
        refrigerator.maintenance();
        refrigerator.turnOff();

        System.out.println();

        AirConditioner ac =
                new AirConditioner(
                        "Daikin",
                        1800,
                        22
                );

        ac.displayAC();
        ac.turnOn();
        ac.performFunction();
        ac.maintenance();
        ac.turnOff();
    }
}
