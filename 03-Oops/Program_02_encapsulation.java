
class Car {

    // Instance Fields
    private String make;
    private String model;
    private String color;
    private int doors;
    private boolean convertible;

    // Setter Methods
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    // Method
    public void describeCar() {

        System.out.println("Make : " + make);
        System.out.println("Model : " + model);
        System.out.println("Color : " + color);
        System.out.println("Doors : " + doors);
        System.out.println("Convertible : " + convertible);

    }
}

public class Program_02_encapsulation {

    public static void main(String[] args) {

        Car tesla = new Car();

        tesla.setMake("Tesla");
        tesla.setModel("Model X");
        tesla.setColor("White");
        tesla.setDoors(4);
        tesla.setConvertible(false);

        tesla.describeCar();

    }
}